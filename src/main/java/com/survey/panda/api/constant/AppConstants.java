package com.survey.panda.api.constant;

public class AppConstants {

    public static final int SURVEYS_PAGE_SIZE = 50;
    public static final int SURVEY_RESPONSES_PAGE_SIZE = 50;

    public static final String ROUTE_HEALTH_CHECK_BASE = "/health";
    public static final String ROUTE_SURVEY_BASE = "/surveys";
    public static final String ROUTE_SURVEY_GET_BY_ID = "/{id}";
    public static final String ROUTE_SURVEY_GET_RESPONSES_BY_ID = "/{id}/responses";

    public static final String MESSAGE_SOME_ERROR_OCCURRED = "Some error occurred. Please try again.";
    public static final String MESSAGE_RESOURCE_NOT_FOUND = "Requested resource not found. Please check if the id is correct.";
    public static final String MESSAGE_SUCCESS = "Success";
    public static final String MESSAGE_HEALTHCHECK = "Service is up and running!";
}
