package com.wqs.argu_backend.bean;

public class PopularScheme {
    private String type;
    private String title;
    private String gaccPremise; // Generally Acceptance Premiese
    private String presuPremise; // Presumption Premise
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

    public String getGaccPremise() {
        return gaccPremise;
    }

    public void setGaccPremise(String gaccPremise) {
        this.gaccPremise = gaccPremise;
    }

    public String getPresuPremise() {
        return presuPremise;
    }

    public void setPresuPremise(String presuPremise) {
        this.presuPremise = presuPremise;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
