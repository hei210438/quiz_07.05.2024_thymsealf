package com.example.quiz07_05_2024;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "q_questions", schema = "quiz")
public class QQuestions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "q_id")
    private int qId;
    @Basic
    @Column(name = "q_text")
    private String qText;
    @OneToMany()
    @JoinColumn
    private Collection<AAnswers> aAnswersByQId;

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public String getqText() {
        return qText;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QQuestions that = (QQuestions) o;

        if (qId != that.qId) return false;
        if (qText != null ? !qText.equals(that.qText) : that.qText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = qId;
        result = 31 * result + (qText != null ? qText.hashCode() : 0);
        return result;
    }

    public QQuestions() {
        this.qId = qId;
        this.qText = qText;
        this.aAnswersByQId = aAnswersByQId;
    }

    public Collection<AAnswers> getaAnswersByQId() {
        return aAnswersByQId;
    }

    public void setaAnswersByQId(Collection<AAnswers> aAnswersByQId) {
        this.aAnswersByQId = aAnswersByQId;
    }
}

