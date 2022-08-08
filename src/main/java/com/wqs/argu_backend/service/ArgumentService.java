package com.wqs.argu_backend.service;

import com.wqs.argu_backend.bean.Argument;
import org.bson.types.ObjectId;

import java.util.List;

public interface ArgumentService {

    int save(Argument arg);

    int updateVote(Argument arg);

    int updateAttackedBy(Argument arg);
    int updateAttackedByEachother(Argument arg);
    int updateListLabel(List<Argument> arg);

    void delete(Integer argid);

    Argument findByArgument_Id(ObjectId a_id);
    Argument findByArgumentId(Integer argid);
    List<Argument> findByFrameworkId(Integer fid);
    Argument findByFrameworkIdAndAFid(Integer fid,Integer afid);

    List<Argument> search(String title);

    Integer findMaxAId();
    Integer findMaxFId();
    Integer findMaxAFId(Integer fid);


    List<Argument> findAll();
    List<Argument> findAllFramework();
}
