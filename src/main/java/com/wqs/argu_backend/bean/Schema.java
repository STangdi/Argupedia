package com.wqs.argu_backend.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
//@Data
//@Document
public class Schema {
    //@Field("type")
    private String type; // the type of argument scheme
    private String title; // the type of argument scheme

    // Action Scheme
    private String currentR;
    private String action;
    private String new_s; //new circumstance
    private String goal;
    private String value;

    //Position to know Scheme, Expert Scheme
    private String majorPremise; // Majorpremise
    private String minorPremise; // Minorpremise
    private String conclusion;

    //Popular opinion Scheme
    private String gaccPremise; // Generally Acceptance Premise
    private String presuPremise; // Presumption Premise
    //private String conclusion;

    // Analogy Scheme
    private String similarPremise; // Similarity Premise
    private String basePremise; // Base Premise
    //private String conclusion;

    //Correlation to Cause Scheme
    private String corrPremise; //Correlation Premise
    //private String conclusion;
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

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrentR() {
        return currentR;
    }

    public void setCurrentR(String currentR) {
        this.currentR = currentR;
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
