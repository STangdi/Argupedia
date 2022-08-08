package com.wqs.argu_backend.controller;

import com.wqs.argu_backend.bean.Argument;
import com.wqs.argu_backend.bean.AttackInfo;
import com.wqs.argu_backend.bean.Schema;
import com.wqs.argu_backend.grounded.G_Labelling;
import com.wqs.argu_backend.service.ArgumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping( "/view")
public class View {

    @Autowired
    private ArgumentService argDao;

    @RequestMapping( "/displayFramework")// Argument Display  page
    @ResponseBody
    public Object displayArgument(@RequestBody String current_fid,Model model){
        System.out.println(current_fid);
        List<Argument> argLists = argDao.findByFrameworkId(Integer.parseInt(current_fid));
        System.out.println("There are "+argLists.size()+"Argument");

        System.out.println("start testing labelling algorithm find the arguments of framework"+current_fid+"are:");

        if(!argLists.isEmpty()){

            int sizes = argLists.size();
            System.out.println(sizes);
            if(sizes>1){
                Grounded(sizes, argLists, true);
            }
        }

        return argLists;
    }

    @RequestMapping( "/searchFid") //Search an argument framework by id, search.html
    public String Search(String search_fid,HttpServletRequest request, Model model){
        int s_fid = Integer.parseInt(search_fid);

        Argument title = argDao.findByFrameworkIdAndAFid(Integer.parseInt(search_fid),0);
        if(title!=null){
            model.addAttribute("Fid", search_fid);
            model.addAttribute("Ftitle", title.getTitle());
            return "select"; //select.html
        }else{
            return "view"; //view.html
        }

    }

    @RequestMapping( "/All") // Framework List page
    @ResponseBody
    public Object displayFramework(){
        List<Argument> allFrame = argDao.findAllFramework();
        int flength = allFrame.size();
        String[][] frameInfo= new String [flength][3];

        for(int i=0; i<flength;i++){
            Argument arg = allFrame.get(i);
            frameInfo[i][0]=""+arg.getFid();
            frameInfo[i][1]=arg.getTitle();
            List<Argument> allFargs = argDao.findByFrameworkId(arg.getFid());
            frameInfo[i][2]=""+allFargs.size();
        }

        return frameInfo;
    }

    @RequestMapping( "/viewone")
    //Click on one of the argument framework title on the
    // Framework List page(view.html) to go to the Argument Display page(select.html)
    public String ViewOne(String selectedFid,HttpServletRequest request, Model model){

        int s_fid = Integer.parseInt(selectedFid);
        HttpSession session = request.getSession();

        session.setAttribute("Fid",selectedFid);
        Argument title = argDao.findByFrameworkIdAndAFid(Integer.parseInt(selectedFid),0);
        model.addAttribute("Fid", selectedFid);
        model.addAttribute("Ftitle", title.getTitle());


        return "select";
    }

    @RequestMapping( "/searchTitle")//Search argument frameworks by title view.html
    @ResponseBody
    public Object SearchTitle(@RequestBody String searchTitle){
        List<Argument> allFrame = argDao.findAllFramework();
        int flength = allFrame.size();

        int index1 = 0;
        int index2 = 0;
        String search_title = searchTitle.toLowerCase();
        for (Argument arg : allFrame) {
            System.out.println(arg.getTitle());
            String resultitle = arg.getTitle().toLowerCase();
            System.out.println(resultitle.contains(search_title));
            if (resultitle.contains(search_title)){
                index1++;
            }
        }

        if(index1>0){
            String[][] frameInfo= new String [index1][3];
            for (Argument arg : allFrame) {
                String resultitle2 = arg.getTitle().toLowerCase();
                if (resultitle2.contains(search_title)){
                    frameInfo[index2][0] = "" + arg.getFid();
                    frameInfo[index2][1] = arg.getTitle();
                    List<Argument> allFargs = argDao.findByFrameworkId(arg.getFid());
                    frameInfo[index2][2] = "" + allFargs.size();
                    index2++;
                }
            }
            if(frameInfo[0][0]==null){
                return "fail";
            }else{
                return frameInfo;
            }
        }else{
            return "fail";
        }
    }

    @RequestMapping( "/addvote")
    //Add 1 to the number of user votes for an argument, Argument Display page(select.html)
    @ResponseBody
    public String Vote(@RequestBody AttackInfo attack, Model model){
        System.out.println(attack.getCurrentFid()+"  "+attack.getAttacked_afid()+" "+attack.getType());

        int currentFid = Integer.parseInt(attack.getCurrentFid());
        int currentAFid = Integer.parseInt(attack.getAttacked_afid());
        Argument voteArg = argDao.findByFrameworkIdAndAFid(currentFid, currentAFid);
        int oldvote = voteArg.getVote();
        System.out.println("oldvote"+oldvote);
        voteArg.setVote(oldvote+1);
        int voteresult = argDao.updateVote(voteArg);
        System.out.println(voteresult);
        if(voteresult>0){
            return "success";
        }else{
            return "fail";
        }
    }

    @RequestMapping( "/vote") //Voting functionality, Display Argument page(select.html)
    @ResponseBody
    public Object displayVote(@RequestBody String currFid){
        System.out.println("Vote currFid:"+currFid);

        List<Argument> voteLists = argDao.findByFrameworkId(Integer.parseInt(currFid));
        System.out.println("There are "+voteLists.size()+"Argument");

        if(!voteLists.isEmpty()){
            int sizes = voteLists.size();
            System.out.println(sizes);
            for(int v=0; v<sizes; v++){
                Argument votearg = voteLists.get(v);
                String vid = ""+votearg.getAfid();
                String vlabel = votearg.getLabel();
                System.out.println("afid:"+vid);
                System.out.println("label:"+vlabel);
                if(vlabel.equals("UNDEC")){
                    String attackid = votearg.getAttack();
                    System.out.println("attack:"+attackid);
                    for(Argument attarg : voteLists) {
                        String findid = ""+attarg.getAfid();
                        String findlabel = attarg.getLabel();
                        if(findid.equals(attackid)&&findlabel.equals("UNDEC")){
                            System.out.println("find afid:"+findid);
                            System.out.println("find label:"+findlabel);
                            String findattack = attarg.getAttack();
                            if(vid.equals(findattack) && !findattack.equals("")){
                                System.out.println("find attack:"+attarg.getAttack());
                                System.out.println("vote1:"+votearg.getVote());
                                System.out.println("vote2 attack:"+attarg.getVote());
                                if(votearg.getVote()>attarg.getVote()){
                                    System.out.println("1>2");
                                    attarg.setAttack("");
                                    String[] modify = votearg.getAttacked_by();
                                    for(int m=0; m<3; m++){
                                        if(modify[m].equals(findid)){
                                            modify[m]="";
                                            break;
                                        }
                                    }
                                    votearg.setAttacked_by(modify);
                                }
                                if(attarg.getVote()> votearg.getVote()){
                                    System.out.println("2>1");
                                    votearg.setAttack("");
                                    String[] modify2 = attarg.getAttacked_by();
                                    for(int m=0; m<3; m++){
                                        if(modify2[m].equals(vid)){
                                            modify2[m]="";
                                            break;
                                        }
                                    }
                                    attarg.setAttacked_by(modify2);
                                }
                            }

                        }
                    }
                }
            }
            if(sizes>1){
                Grounded(sizes, voteLists, false);
            }
        }

        return voteLists;
    }

    //Determine if two arrays are equal
    public int findArray(String[] array,String e){
        for(int i = 0;i<array.length;i++){
            if(array[i].equals(e)){
                //System.out.println("i: "+array[i]+" "+e);
                return i;
            }
        }
        return -1;
    }

    //    Calling the labeling algorithm for grounded semantics(G_Labelling())
    public void Grounded(int size, List<Argument> argList, Boolean flag){
        String[]argu = new String[size];
        String[][] label = new String[size][3];
        for(int i=0;i<size;i++) {
            System.out.println("fid:"+argList.get(i).getFid()+" afid:"+argList.get(i).getAfid()+
                    " attacked by " + argList.get(i).getAttacked_by()[0]+" "+argList.get(i).getAttacked_by()[1]+
                    ""+argList.get(i).getAttacked_by()[2]+" aid:" + argList.get(i).getAid());
            argu[i] = ""+argList.get(i).getAfid();

            label[i]=argList.get(i).getAttacked_by();

        }
        String[][] test = {{"a","b","c","d","e"},{"","a","b","e","d"}};
        System.out.println("------all afid are:");
        System.out.println(Arrays.toString(label[0]));
        System.out.println("----attacked by:");
        System.out.println(Arrays.toString(label[1]));
        G_Labelling glabel = new G_Labelling();

        String[][] l_result=glabel.ground(argu,label);
        System.out.println("---------l_result");
        System.out.println(Arrays.deepToString(l_result));
        System.out.println(Arrays.toString(l_result[0]));
        for (Argument argument : argList) {
            String element = "" + argument.getAfid();
            System.out.println("element:" +element);
            int index = findArray(l_result[0], element);
            if (index >= 0) {
                argument.setLabel(l_result[1][index]);
            }
            System.out.println(" afid:" + argument.getAfid() + " label:" + argument.getLabel());
        }
    }
}
