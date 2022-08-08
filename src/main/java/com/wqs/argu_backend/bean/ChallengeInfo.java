package com.wqs.argu_backend.bean;

public class ChallengeInfo {
    private  String c_fid; //Current fid

    private String a_afid; // afid of the attacked argument
    private String title;
    private String type; //the type of challenge: premise or attack
    // @Field("currentR")

    private Schema scheme;
    private String currentR;
    //@Field("action")
    private String action;
    private String new_s; //new circumstance
    private String goal;
    private String value;

    //Position to know Scheme, Expert Scheme
    private String majorPremise; // Majorpremise
    private String minorPremise; // Minorpremise
    private String conclusion;

    //Popular opinion Scheme
    private String gaccPremise; // Generally Acceptance Premiese
    private String presuPremise; // Presumption Premise
    //private String conclusion;

    // Analogy Scheme
    private String similarPremise; // Similarity Premise
    private String basePremise; // Base Premise
    //private String conclusion;

    //Correlation to Cause Scheme
    private String corrPremise; //Correlation Premise
    //private String conclusion;

    public String getC_fid() {
        return c_fid;
    }

    public void setC_fid(String c_fid) {
        this.c_fid = c_fid;
    }

    public String getA_afid() {
        return a_afid;
    }

    public void setA_afid(String a_afid) {
        this.a_afid = a_afid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Schema getScheme() {
        return scheme;
    }

    public void setScheme(Schema scheme) {
        this.scheme = scheme;
    }

    public String getCurrentR() {
        return currentR;
    }

    public void setCurrentR(String currentR) {
        this.currentR = currentR;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNew_s() {
        return new_s;
    }

    public void setNew_s(String new_s) {
        this.new_s = new_s;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getCorrPremise() {
        return corrPremise;
    }

    public void setCorrPremise(String corrPremise) {
        this.corrPremise = corrPremise;
    }
}
