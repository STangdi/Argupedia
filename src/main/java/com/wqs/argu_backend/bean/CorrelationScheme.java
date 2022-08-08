package com.wqs.argu_backend.bean;

public class CorrelationScheme {
    private String type;
    private String title;
    private String corrPremise; //Correlation Premise
    private String conclusion;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCorrPremise() {
        return corrPremise;
    }

    public void setCorrPremise(String corrPremise) {
        this.corrPremise = corrPremise;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
