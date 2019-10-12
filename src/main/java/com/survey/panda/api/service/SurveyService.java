package com.survey.panda.api.service;

import com.survey.panda.api.constant.AppConstants;
import com.survey.panda.api.constant.QuestionType;
import com.survey.panda.api.exception.SurveyInvalidRequestException;
import com.survey.panda.api.model.Question;
import com.survey.panda.api.model.Survey;
import com.survey.panda.api.repository.QuestionRepository;
import com.survey.panda.api.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Survey> getAllSurveys(int offset) {
        return surveyRepository.findAll(PageRequest.of(offset, AppConstants.SURVEYS_PAGE_SIZE)).getContent();
    }

    @Transactional(rollbackOn = {SurveyInvalidRequestException.class})
    public Survey createNewSurvey(Survey request) throws SurveyInvalidRequestException {

        Survey survey = new Survey();

        if (request.getTitle() == null || request.getTitle().isEmpty())
            throw new SurveyInvalidRequestException("Title cannot be empty");
        survey.setTitle(request.getTitle());

        if (request.getTags() != null)
            survey.setTags(request.getTags());
        else
            survey.setTags(new ArrayList<>());

        survey.setCreatedBy("TODO");
        survey.setCreatedOn(LocalDateTime.now());

        if (request.getQuestions() == null || request.getQuestions().size() == 0)
            throw new SurveyInvalidRequestException("At least one question is required to create a survey");
        survey.setQuestions(new ArrayList<>());

        survey = surveyRepository.save(survey);

        for (Question question : request.getQuestions()) {
            if (question.getType() == null)
                question.setType(QuestionType.TEXT);

            if (question.getText() == null || question.getText().isEmpty())
                throw new SurveyInvalidRequestException("Question text cannot be empty");

            if (question.getType() == QuestionType.TEXT)
                question.setOptions(new ArrayList<>());
            else if (question.getOptions() == null || question.getOptions().size() == 0)
                throw new SurveyInvalidRequestException("Question must have options with type select/multiselect");

            question.setSurveyId(survey.getId());
        }

        questionRepository.saveAll(request.getQuestions());
        survey.setQuestions(request.getQuestions());

        return survey;
    }

    public Survey getSurveyById(UUID id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        return survey.orElse(null);
    }

}
