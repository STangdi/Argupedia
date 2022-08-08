package com.wqs.argu_backend.bean;

public class AttackInfo {
    private  String currentFid;
    private  String attacked_afid;
    private String type;

    public String getCurrentFid() {
        return currentFid;
    }

    public void setCurrentFid(String currentFid) {
        this.currentFid = currentFid;
    }

    public String getAttacked_afid() {
        return attacked_afid;
    }

    public void setAttacked_afid(String attacked_afid) {
        this.attacked_afid = attacked_afid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
