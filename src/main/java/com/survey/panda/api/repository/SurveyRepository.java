package com.survey.panda.api.repository;

import com.survey.panda.api.model.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SurveyRepository extends CrudRepository<Survey, UUID> {

    Page<Survey> findAll(Pageable pageable);

    Page<Survey> findByCreatedBy(String creator, Pageable pageable);
}
