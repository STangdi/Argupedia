package com.wqs.argu_backend.controller;

import com.wqs.argu_backend.bean.*;
import com.wqs.argu_backend.service.ArgumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping( "/argument")
public class Create {

    @Autowired
    private ArgumentService argDao;

    @RequestMapping( "/action")
    public String createAction(ActionScheme actionscheme, Model model, HttpServletRequest request){//RedirectAttributes attr
        System.out.println("----------------------action-------");
        System.out.println(actionscheme.getTitle());
        System.out.println(actionscheme.getCurrentR());
        System.out.println(actionscheme.getAction());
        System.out.println(actionscheme.getNew_s());
        System.out.println(actionscheme.getValue());
        System.out.println(actionscheme.getGoal());
        actionscheme.setType("Action");


        Argument action_arg = new Argument();
        action_arg.setSchema(actionscheme);
        action_arg.setLabel("IN");
        action_arg.setVote(0);
        action_arg.setTitle(actionscheme.getTitle());
        System.out.println(action_arg.getSchema());
        int fid = initialFramework(action_arg);
        System.out.println(fid);
        model.addAttribute("Fid", fid);
        model.addAttribute("Ftitle", actionscheme.getTitle());
        //attr.addFlashAttribute("Fid",fid);

        return "select";
    }

    @RequestMapping( "/expert")
    public String createExpert(ExpertScheme exscheme, Model model, HttpServletRequest request){
        System.out.println("----------------------Expert-------");
        System.out.println(exscheme.getTitle());
        System.out.println(exscheme.getMajorPremise());
        System.out.println(exscheme.getMinorPremise());
        System.out.println(exscheme.getConclusion());
        exscheme.setType("Expert Opinion");

        Argument ex_arg = new Argument();
        ex_arg.setSchema(exscheme);
        ex_arg.setLabel("IN");
        ex_arg.setVote(0);
        ex_arg.setTitle(exscheme.getTitle());
        int fid = initialFramework(ex_arg);
        System.out.println(fid);
        model.addAttribute("Fid", fid);
        //model.addAttribute("Ftitle", scheme.getTitle());
        model.addAttribute("Ftitle", exscheme.getTitle());

        return "select";
    }

    @RequestMapping( "/position")
    public String createPosition(PositionScheme pscheme, Model model, HttpServletRequest request){
        System.out.println("----------------------Position-------");
        System.out.println(pscheme.getTitle());
        System.out.println(pscheme.getMajorPremise());
        System.out.println(pscheme.getMinorPremise());
        System.out.println(pscheme.getConclusion());
        pscheme.setType("Position to Know");


        Argument posi_arg = new Argument();
        //posi_arg.setSchema(posi_s);
        posi_arg.setSchema(pscheme);
        posi_arg.setLabel("IN");
        posi_arg.setVote(0);
        posi_arg.setTitle(pscheme.getTitle());
        int fid = initialFramework(posi_arg);
        System.out.println(fid);
        model.addAttribute("Fid", fid);
        model.addAttribute("Ftitle", pscheme.getTitle());

        HttpSession session = request.getSession();
        if (session.getAttribute("Fid") == null) {
            System.out.println("no session");
            session.setAttribute("Fid", fid);//session.setAttribute("user", "zhangsan");
            //session.setAttribute("Ftitle", pscheme.getTitle());
            System.out.println("create session");
        } else {
            System.out.println("has session");
        }

        return "select";
    }

    @RequestMapping( "/popular")
    //@ResponseBody
    public String createPopular(PopularScheme popscheme, Model model, HttpServletRequest request){
        System.out.println("----------------------popular-------");
        System.out.println(popscheme.getTitle());
        System.out.println(popscheme.getGaccPremise());
        System.out.println(popscheme.getPresuPremise());
        System.out.println(popscheme.getConclusion());
        popscheme.setType("Popular Opinion");

        Argument pop_arg = new Argument();
        pop_arg.setSchema(popscheme); //pop_arg.setSchema(pop_s);
        pop_arg.setLabel("IN");
        pop_arg.setVote(0);
        pop_arg.setTitle(popscheme.getTitle());
        int fid = initialFramework(pop_arg);
        System.out.println(fid);
        model.addAttribute("Fid", fid);
        model.addAttribute("Ftitle", popscheme.getTitle());

        HttpSession session = request.getSession();
        if (session.getAttribute("Fid") == null) {
            System.out.println("no session");
            session.setAttribute("Fid", fid);//session.setAttribute("user", "zhangsan");
            System.out.println("create session");
        } else {
            System.out.println("has session");
        }

        return "select";
    }
    @RequestMapping( "analogy")
    public String createAnalogy(AnalogyScheme anascheme, Model model, HttpServletRequest request){
        System.out.println("----------------------analogy------");
        System.out.println(anascheme.getTitle());
        System.out.println(anascheme.getSimilarPremise());
        System.out.println(anascheme.getBasePremise());
        System.out.println(anascheme.getConclusion());
        anascheme.setType("Analogy");

        Argument ana_arg = new Argument();
        ana_arg.setSchema(anascheme); //ana_arg.setSchema(ana_s);
        ana_arg.setLabel("IN");
        ana_arg.setVote(0);
        ana_arg.setTitle(anascheme.getTitle());
        int fid = initialFramework(ana_arg);
        System.out.println(fid);
        model.addAttribute("Fid", fid);
        model.addAttribute("Ftitle", anascheme.getTitle());


        return "select";
    }

    @RequestMapping( "/correlation")
    public String createCorrelation(CorrelationScheme corrscheme, Model model){
        System.out.println("----------------------correlation-------");
        System.out.println(corrscheme.getTitle());
        System.out.println(corrscheme.getCorrPremise());
        System.out.println(corrscheme.getConclusion());
        corrscheme.setType("Correlation to Cause");

        Argument corr_arg = new Argument();
        corr_arg.setSchema(corrscheme); //corr_arg.setSchema(corr_s);
        corr_arg.setLabel("IN");
        corr_arg.setVote(0);
        corr_arg.setTitle(corrscheme.getTitle());
        int fid = initialFramework(corr_arg);
        System.out.println(fid);
        model.addAttribute("Fid", fid);
        model.addAttribute("Ftitle", corrscheme.getTitle());



        return "select";
    }

    public int initialFramework(Argument initArg){
        System.out.println("----max_aid: "+argDao.findMaxAId()+"  max_fid: "+argDao.findMaxFId());
        initArg.setAid(argDao.findMaxAId()+1);
        initArg.setFid(argDao.findMaxFId()+1);
        initArg.setAfid(0);
        initArg.setAttack("");
        String[] att = {"","",""};
        initArg.setAttacked_by(att);

        int result = argDao.save(initArg);
        System.out.println(result);
        if(result>0){
            System.out.println("new data save success");
            System.out.println("new aid:"+initArg.getAid()+" fid:"+initArg.getFid());
            return initArg.getFid();
        }else{
            System.out.println("new data save fail");
            return -1;
        }

    }

}
