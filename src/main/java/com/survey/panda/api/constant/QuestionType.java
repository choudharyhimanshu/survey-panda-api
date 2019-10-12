package com.survey.panda.api.constant;

public enum QuestionType {
    TEXT("text"),
    SELECT("select"),
    MULTI_SELECT("multi-select");

    private String value;

    QuestionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
