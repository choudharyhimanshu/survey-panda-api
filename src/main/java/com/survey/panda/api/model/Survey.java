package com.survey.panda.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "survey")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    @ElementCollection
    private List<String> tags;

    private LocalDateTime createdOn;

    private String createdBy;

    @OneToMany(mappedBy = "surveyId", cascade = CascadeType.ALL)
    private List<Question> questions;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tags=" + tags +
                ", createdOn=" + createdOn +
                ", createdBy='" + createdBy + '\'' +
                ", questions=" + questions +
                '}';
    }
}
