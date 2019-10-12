package com.survey.panda.api.repository;

import com.survey.panda.api.model.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, UUID> {

}
