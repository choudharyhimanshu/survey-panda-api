package com.survey.panda.api.repository;

import com.survey.panda.api.model.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResponseRepository extends CrudRepository<Response, UUID> {

    Page<Response> findAllBySurveyId(UUID id, Pageable pageable);

}
