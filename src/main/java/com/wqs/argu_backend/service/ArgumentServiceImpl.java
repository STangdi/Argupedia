package com.wqs.argu_backend.service;

import com.wqs.argu_backend.bean.Argument;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Component;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArgumentServiceImpl implements ArgumentService{

   @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public int save(Argument arg) {
        try {
            mongoTemplate.save(arg,"arg");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        //mongoTemplate.insert(arg);
        //return null;
    }

    @Override
    public int updateVote(Argument argvote) {
        try {
            Query query = new Query(Criteria.where("_id").is(argvote.getId()));
            Update update = Update.update("vote",argvote.getVote());
            mongoTemplate.upsert(query,update,Argument.class,"arg");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateAttackedBy(Argument argone) {
        try {
            Query query = new Query(Criteria.where("_id").is(argone.getId()));
            Update update = Update.update("attacked_by",argone.getAttacked_by());
            mongoTemplate.upsert(query,update,Argument.class,"arg");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        //return null;
    }

    @Override
    public int updateAttackedByEachother(Argument argone) {
        try {
            Query query = new Query(Criteria.where("_id").is(argone.getId()));
            Update update = new Update();
            update.set("attack",argone.getAttack());
            update.set("attacked_by",argone.getAttacked_by());
            mongoTemplate.upsert(query,update,Argument.class,"arg");
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        //return null;
    }

    @Override
    public int updateListLabel(List<Argument> argLists) {
        try {
            for(Argument arg: argLists){
                Query query = new Query(Criteria.where("_id").is(arg.getId()));
                Update update = Update.update("label",arg.getLabel());
                mongoTemplate.upsert(query,update,Argument.class,"arg");
            }
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        //return null;
    }

    @Override
    public void delete(Integer argid) {

    }

    @Override
    public Argument findByArgument_Id(ObjectId a_id) {
        Query query = new Query(Criteria.where("_id").is(a_id));
        Argument arg = mongoTemplate.findOne(query,Argument.class,"arg");
        return arg;
    }

    @Override
    public Argument findByArgumentId(Integer argid) {
        //return null;
        Query query = new Query(Criteria.where("aid").is(argid));

        Argument arg = mongoTemplate.findOne(query,Argument.class,"arg");
        if(arg!=null){

            return arg;
        }else{
            return null;
        }
    }

    @Override
    public List<Argument> search(String title) {
        //Query query = new Query(Criteria.where("fid").is(fid).and("afid").is(afid));
        return null;
    }

    @Override
    public Argument findByFrameworkIdAndAFid(Integer fid, Integer afid) {
        Query query = new Query(Criteria.where("fid").is(fid).and("afid").is(afid));
        Argument arg = mongoTemplate.findOne(query,Argument.class,"arg");
        if(arg!=null){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
        return arg;
    }

    @Override
    public List<Argument> findByFrameworkId(Integer fid) {
        Query query = new Query(Criteria.where("fid").is(fid));
        List<Argument> argList = mongoTemplate.find(query,Argument.class,"arg");
        if(!argList.isEmpty()){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
        return argList;
    }

    @Override
    public List<Argument> findAll() {
        return mongoTemplate.findAll(Argument.class,"arg");
    }

    @Override
    public List<Argument> findAllFramework() {
        Query query = new Query(Criteria.where("afid").is(0));
        return mongoTemplate.find(query,Argument.class,"arg");

    }

    @Override
    public Integer findMaxAId() {
        Query query1 = new Query();
        Sort sort1 = Sort.by(Sort.Direction.DESC,"aid");
        query1.with(sort1);
        query1.limit(1);
        Argument maxaid = mongoTemplate.findOne(query1, Argument.class,"arg");
        if(maxaid!=null){
            System.out.println("aid: "+maxaid.getAid()+" fid:"+maxaid.getFid()+" afid:"+maxaid.getAfid());
            return maxaid.getAid();
        }else {
            System.out.println("fail");
            return -1;
        }
    }

    @Override
    public Integer findMaxFId() {

        Query query2 = new Query();
        Sort sort2 = Sort.by(Sort.Direction.DESC,"fid");
        query2.with(sort2);
        query2.limit(1);
        Argument maxfid = mongoTemplate.findOne(query2, Argument.class,"arg");
        if(maxfid!=null){
            System.out.println("fid: "+maxfid.getFid()+" aid: "+maxfid.getAid()+" afid:"+maxfid.getAfid());
            return maxfid.getFid();
        }else {
            System.out.println("fail");
            return -1;
        }
    }

    @Override
    public Integer findMaxAFId(Integer fid) {
        Query query3 = new Query(Criteria.where("fid").is(fid));
        Sort sort3 = Sort.by(Sort.Direction.DESC,"afid");
        query3.with(sort3);
        query3.limit(1);
        Argument afid = mongoTemplate.findOne(query3, Argument.class,"arg");
        if(afid!=null){
            System.out.println("aid"+afid.getAid()+" fid: "+afid.getFid()+" afid" +afid.getAfid());
            return afid.getAfid();
        }else {
            System.out.println("fail");
            return -1;
        }
    }


}
