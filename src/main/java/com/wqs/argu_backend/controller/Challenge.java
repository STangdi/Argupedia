package com.wqs.argu_backend.controller;

import com.wqs.argu_backend.bean.*;
import com.wqs.argu_backend.service.ArgumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/challengeArgu")
public class Challenge {

    @Autowired
    private ArgumentService argDao;

    @RequestMapping( "/type")
    public String attackType( AttackInfo attack, Model model){
        System.out.println(attack.getCurrentFid()+"  "+attack.getAttacked_afid()+" "+attack.getType());
        model.addAttribute("att_info", attack);

        int currentFid = Integer.parseInt(attack.getCurrentFid());
        int currentAFid = Integer.parseInt(attack.getAttacked_afid());
        Argument challenged = argDao.findByFrameworkIdAndAFid(currentFid, currentAFid);
        System.out.println("challenged"+challenged.getTitle());
        model.addAttribute("att_info", attack);
        model.addAttribute("challengedA", challenged);
        return "challenge";
    }
    @RequestMapping( "/action")
    public String createChallengeArgumentAction(ChallengeInfo acinfo, Model model){
        System.out.println(acinfo.getC_fid()+" "+acinfo.getA_afid()+" "+acinfo.getType());

        ActionScheme a_s = new ActionScheme();
        a_s.setType("Action");
        a_s.setTitle(acinfo.getTitle());
        a_s.setCurrentR(acinfo.getCurrentR());
        a_s.setAction(acinfo.getAction());
        a_s.setNew_s(acinfo.getNew_s());
        a_s.setGoal(acinfo.getGoal());
        a_s.setValue(acinfo.getValue());

        Argument ac_arg = new Argument();
        ac_arg.setSchema(a_s);
        ac_arg.setLabel("");
        ac_arg.setVote(0);
        int challResult = initialAttack(ac_arg, acinfo);
        System.out.println(challResult);
        model.addAttribute("Fid", acinfo.getC_fid());
        model.addAttribute("Ftitle", acinfo.getTitle());

        return "select";
    }

    @RequestMapping( "/expert")
    public String createChallengeArgumentExpert(ChallengeInfo excinfo, Model model){
        System.out.println(excinfo.getC_fid()+" "+excinfo.getA_afid()+" "+excinfo.getType());

        ExpertScheme ex_s = new ExpertScheme();
        ex_s.setType("Expert Opinion");
        ex_s.setTitle(excinfo.getTitle());
        ex_s.setTitle(excinfo.getTitle());
        ex_s.setMajorPremise(excinfo.getMajorPremise());
        ex_s.setMinorPremise(excinfo.getMinorPremise());
        ex_s.setConclusion(excinfo.getConclusion());

        Argument ex_arg = new Argument();
        ex_arg.setSchema(ex_s);
        ex_arg.setLabel("");
        ex_arg.setVote(0);
        int challResult = initialAttack(ex_arg, excinfo);
        System.out.println(challResult);
        model.addAttribute("Fid", excinfo.getC_fid());
        model.addAttribute("Ftitle", excinfo.getTitle());

        return "select";
    }

    @RequestMapping( "/position")
    public String createChallengeArgumentPosition(ChallengeInfo posicinfo, Model model){
        System.out.println(posicinfo.getC_fid()+" "+posicinfo.getA_afid()+" "+posicinfo.getType());

        PositionScheme posi_s = new PositionScheme();
        posi_s.setType("Position to Know");
        posi_s.setTitle(posicinfo.getTitle());
        posi_s.setMajorPremise(posicinfo.getMajorPremise());
        posi_s.setMinorPremise(posicinfo.getMinorPremise());
        posi_s.setConclusion(posicinfo.getConclusion());

        Argument posi_arg = new Argument();
        posi_arg.setSchema(posi_s);
        posi_arg.setLabel("");
        posi_arg.setVote(0);
        int challResult = initialAttack(posi_arg, posicinfo);
        System.out.println(challResult);
        model.addAttribute("Fid", posicinfo.getC_fid());
        model.addAttribute("Ftitle", posicinfo.getTitle());

        return "select";
    }

    @RequestMapping( "/popular")
    public String createChallengeArgumentPopular(ChallengeInfo popcinfo, Model model){
        System.out.println(popcinfo.getC_fid()+" "+popcinfo.getA_afid()+" "+popcinfo.getType());

        PopularScheme pop_s = new PopularScheme();
        pop_s.setType("Popular Opinion");
        pop_s.setTitle(popcinfo.getTitle());
        pop_s.setGaccPremise(popcinfo.getGaccPremise());
        pop_s.setPresuPremise(popcinfo.getPresuPremise());
        pop_s.setConclusion(popcinfo.getConclusion());

        Argument pop_arg = new Argument();
        pop_arg.setSchema(pop_s);
        pop_arg.setLabel("");
        pop_arg.setVote(0);
        int challResult = initialAttack(pop_arg, popcinfo);
        System.out.println(challResult);
        model.addAttribute("Fid", popcinfo.getC_fid());
        model.addAttribute("Ftitle", popcinfo.getTitle());

        return "select";
    }

    @RequestMapping( "/analogy")
    public String createChallengeArgumentAnalogy(ChallengeInfo anacinfo, Model model){
        System.out.println(anacinfo.getC_fid()+" "+anacinfo.getA_afid()+" "+anacinfo.getType());

        AnalogyScheme ana_s = new AnalogyScheme();
        ana_s.setType("Analogy");
        ana_s.setTitle(anacinfo.getTitle());
        ana_s.setSimilarPremise(anacinfo.getSimilarPremise());
        ana_s.setBasePremise(anacinfo.getBasePremise());
        ana_s.setConclusion(anacinfo.getConclusion());

        Argument ana_arg = new Argument();
        ana_arg.setSchema(ana_s);
        ana_arg.setLabel("");
        ana_arg.setVote(0);
        int challResult = initialAttack(ana_arg, anacinfo);
        System.out.println(challResult);
        model.addAttribute("Fid", anacinfo.getC_fid());
        model.addAttribute("Ftitle", anacinfo.getTitle());

        return "select";
    }

    @RequestMapping( "/correlation")
    public String createChallengeArgumentCorrelation(ChallengeInfo corrcinfo, Model model){
        System.out.println(corrcinfo.getC_fid()+" "+corrcinfo.getA_afid()+" "+corrcinfo.getType());

        CorrelationScheme corr_s = new CorrelationScheme();
        corr_s.setType("Correlation to Cause");
        corr_s.setTitle(corrcinfo.getTitle());
        corr_s.setCorrPremise(corrcinfo.getCorrPremise());
        corr_s.setConclusion(corrcinfo.getConclusion());

        Argument corr_arg = new Argument();
        corr_arg.setSchema(corr_s);
        corr_arg.setLabel("");
        corr_arg.setVote(0);
        int challResult = initialAttack(corr_arg, corrcinfo);
        System.out.println(challResult);
        model.addAttribute("Fid", corrcinfo.getC_fid());
        model.addAttribute("Ftitle", corrcinfo.getTitle());

        return "select";
    }



    /*@RequestMapping( "/premise")
    public String attackPremise(Schema ac_s){
        return "";
    }
    @RequestMapping( "/conclusion")
    public String attackConclusion(Schema ac_s){
        return "";
    }*/

    public int initialAttack(Argument attArg, ChallengeInfo cinfo){
       int cfid = Integer.parseInt(cinfo.getC_fid());
        int aafid = Integer.parseInt(cinfo.getA_afid());

        System.out.println(argDao.findMaxAId()+" "+argDao.findMaxFId()+" "+argDao.findMaxAFId(cfid));
        attArg.setAid(argDao.findMaxAId()+1);
        attArg.setFid(cfid);
        attArg.setAfid(argDao.findMaxAFId(cfid)+1);
        attArg.setAttack(cinfo.getA_afid()); // ac_arg attack aafid   premise
        Argument be_attacked_arg = argDao.findByFrameworkIdAndAFid(cfid,aafid);
        String[] attArry = be_attacked_arg.getAttacked_by();
        for(int i=0; i<3; i++){
            if("".equals(attArry[i])){
                attArry[i]=""+attArg.getAfid();
            }
        }
        int result2=0;
        if("attack".equals(cinfo.getType())){
            String[] initArry1 = {"","",""};
            be_attacked_arg.setAttack(""+attArg.getAfid());
            initArry1[0] = ""+aafid;
            attArg.setAttacked_by(initArry1); // ""+aafid); // ac_arg is attacked by aafid conclusion
            result2 = argDao.updateAttackedByEachother(be_attacked_arg);
        }else{
            String[] initArry2 = {"","",""};
            attArg.setAttacked_by(initArry2);
            result2 = argDao.updateAttackedBy(be_attacked_arg);
        }

        int result = argDao.save(attArg);
        System.out.println(result);
        if(result>0&&result2>0){
            return 0;
        }else{
            return -1;
        }
    }
}
