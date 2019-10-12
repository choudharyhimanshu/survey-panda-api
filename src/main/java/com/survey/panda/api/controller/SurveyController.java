package com.survey.panda.api.controller;

import com.survey.panda.api.constant.AppConstants;
import com.survey.panda.api.exception.SurveyInvalidRequestException;
import com.survey.panda.api.model.Survey;
import com.survey.panda.api.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(AppConstants.ROUTE_SURVEY_BASE)
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<Survey>> getSurveys(@RequestParam(defaultValue = "0") int offset) {
        List<Survey> surveys = surveyService.getAllSurveys(offset);

        if (surveys == null) {
            return new ResponseEntity(AppConstants.MESSAGE_SOME_ERROR_OCCURRED, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(surveys, HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey request) {
        Survey survey = null;
        try {
            survey = surveyService.createNewSurvey(request);
        } catch (SurveyInvalidRequestException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        if (survey == null) {
            return new ResponseEntity(AppConstants.MESSAGE_SOME_ERROR_OCCURRED, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(survey, HttpStatus.OK);
    }

    @GetMapping(AppConstants.ROUTE_SURVEY_GET_BY_ID)
    @ResponseBody
    public ResponseEntity<Survey> getSurveyById(@PathVariable("id") UUID id) {
        Survey survey = surveyService.getSurveyById(id);

        if (survey == null) {
            return new ResponseEntity(AppConstants.MESSAGE_RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(survey, HttpStatus.OK);
    }
}
