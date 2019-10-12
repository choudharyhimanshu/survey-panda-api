package com.survey.panda.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.survey.panda.api.constant.QuestionType;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonIgnore
    private UUID surveyId;

    private String text;

    private boolean isRequired;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @ElementCollection
    private List<String> options;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(UUID surveyId) {
        this.surveyId = surveyId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", surveyId=" + surveyId +
                ", text='" + text + '\'' +
                ", isRequired=" + isRequired +
                ", type=" + type +
                ", options=" + options +
                '}';
    }
}
