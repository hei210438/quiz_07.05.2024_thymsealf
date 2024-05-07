package com.example.quiz07_05_2024;

import jakarta.persistence.*;

@Entity
@Table(name = "a_answers", schema = "quiz")
public class AAnswers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "a_id")
    private int aId;
    @Basic
    @Column(name = "a_correct")
    private Boolean acorrect;
    @Basic
    @Column(name = "a_text")
    private String aText;
    @Basic
    @Column(name = "a_question_id")
    private Integer aQuestionId;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public Boolean getAcorrect() {
        return acorrect;
    }

    public void setAcorrect(Boolean acorrect) {
        this.acorrect = acorrect;
    }

    public String getaText() {
        return aText;
    }

    public void setaText(String aText) {
        this.aText = aText;
    }

    public Integer getaQuestionId() {
        return aQuestionId;
    }

    public void setaQuestionId(Integer aQuestionId) {
        this.aQuestionId = aQuestionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AAnswers aAnswers = (AAnswers) o;

        if (aId != aAnswers.aId) return false;
        if (acorrect != null ? !acorrect.equals(aAnswers.acorrect) : aAnswers.acorrect != null) return false;
        if (aText != null ? !aText.equals(aAnswers.aText) : aAnswers.aText != null) return false;
        if (aQuestionId != null ? !aQuestionId.equals(aAnswers.aQuestionId) : aAnswers.aQuestionId != null)
            return false;

        return true;
    }

    public AAnswers() {
        this.aId = aId;
        this.acorrect = acorrect;
        this.aText = aText;
        this.aQuestionId = aQuestionId;
    }

    @Override
    public int hashCode() {
        int result = aId;
        result = 31 * result + (acorrect != null ? acorrect.hashCode() : 0);
        result = 31 * result + (aText != null ? aText.hashCode() : 0);
        result = 31 * result + (aQuestionId != null ? aQuestionId.hashCode() : 0);
        return result;
    }
}
