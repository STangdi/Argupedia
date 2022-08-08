package com.wqs.argu_backend.bean;

public class AnalogyScheme {
    private String type;
    private String title;
    private String similarPremise; // Similarity Premise
    private String basePremise; // Base Premise
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

    public String getSimilarPremise() {
        return similarPremise;
    }

    public void setSimilarPremise(String similarPremise) {
        this.similarPremise = similarPremise;
    }

    public String getBasePremise() {
        return basePremise;
    }

    public void setBasePremise(String basePremise) {
        this.basePremise = basePremise;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
