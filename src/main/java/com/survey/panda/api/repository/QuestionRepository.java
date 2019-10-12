package com.survey.panda.api.repository;

import com.survey.panda.api.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestionRepository extends CrudRepository<Question, UUID> {

}
