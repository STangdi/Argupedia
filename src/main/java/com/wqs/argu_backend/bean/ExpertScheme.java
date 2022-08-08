package com.wqs.argu_backend.bean;

public class ExpertScheme {
    private String type;
    private String title;
    //@Field("majorPremise")
    private String majorPremise;
    //@Field("minorPremise")
    private String minorPremise;
    //@Field("conclusion")
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

    public String getMajorPremise() {
        return majorPremise;
    }

    public void setMajorPremise(String majorPremise) {
        this.majorPremise = majorPremise;
    }

    public String getMinorPremise() {
        return minorPremise;
    }

    public void setMinorPremise(String minorPremise) {
        this.minorPremise = minorPremise;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
