package com.wqs.argu_backend.bean;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "args")
public class Argument  {
    @MongoId
    private ObjectId id;
    @Field("aid")
    private Integer aid; // argument id
    @Field("fid")
    //@GeneratedValue
    private Integer fid; // framework id
    @Field("afid")
    private Integer afid; // argument id in a framework
    @Field("title")
    private String title;
    @Field("attack")
    private String attack;
    @Field("attacked_by")
    //private String attacked_by;
    private String[] attacked_by = new String[3];
    @Field("schema")
    private Object schema; // schema type
    //private String content; // arg content
    @Field("label")
    private String label;

    @Field("vote")
    private Integer vote;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getAid() {

        return aid;
    }

    public void setAid(Integer aid) {

        this.aid = aid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getAfid() {
        return afid;
    }

    public void setAfid(Integer afid) {
        this.afid = afid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    /*public String getAttacked_by() {
        return attacked_by;
    }

    public void setAttacked_by(String attacked_by) {
        this.attacked_by = attacked_by;
    }*/

    public String[] getAttacked_by() {
        return attacked_by;
    }

    public void setAttacked_by(String[] attacked_by) {
        this.attacked_by = attacked_by;
    }

    public Object getSchema() {
        return schema;
    }

    public void setSchema(Object schema) {
        this.schema = schema;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String labelling) {
        this.label = labelling;
    }
}
