package com.wqs.argu_backend.grounded;

//import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class G_Labelling {
    //String[] args = {"UNDEC", "UNDEC", "UNDEC"};
    private static boolean equalArray(ArrayList<ArrayList<String>> arr1, ArrayList<ArrayList<String>> arr2) {
        //int len = arr1.length;
        System.out.println("arr1 size:"+arr1.get(0).size()+"  arr2 size"+arr2.get(0).size());
        if(arr1.get(0).size()!=arr2.get(0).size() || arr1.get(1).size()!=arr2.get(1).size()){
            System.out.println("length not equal");
            return  true;
        }
        for(String s1: arr2.get(0)){
            if(!arr1.get(0).contains(s1)){
                System.out.println("elements not same");
                return true;
            };
        }
        for(String s1: arr2.get(1)){
            if(!arr1.get(1).contains(s1)){
                System.out.println("elements not same");
                return true;
            };
        }

        System.out.println("list same");
        return false;

    }


    public String[][] ground(String[] args, String[][] labels) {
        int num = args.length;
        System.out.println(num);


        ArrayList<ArrayList<String>> list1=new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> list2=new ArrayList<ArrayList<String>>();
        ArrayList<String> in=new ArrayList<String>();
        ArrayList<String> out=new ArrayList<String>();
        ArrayList<String> undec=new ArrayList<String>();
        ArrayList<String> in2=new ArrayList<String>();
        ArrayList<String> out2=new ArrayList<String>();
        //ArrayList<String> undec2=new ArrayList<String>();
        list1.add(in);
        list1.add(out);
        list1.add(undec);
        list2.add(in2);
        list2.add(out2);
        //list2.add(undec2);
        int g =4;
        int c =1;
        //String[] ss = new String[5];
       do{
            String ss ="";
            for(String sss: args) {
                    ss = ss+sss;
            }
           System.out.println("ss: "+ss);
            for(String sin: in2){
               if(!in.contains(sin)){
                   in.add(sin);
                   System.out.println("add "+sin+" to IN");
               }
            }
            for(String sout: out2){
               if(!out.contains(sout)){
                   out.add(sout);
                   System.out.println("add "+sout+" to OUT");
               }
            }


            //System.out.println("IN: "+list1.get(0)+"OUT: "+list1.get(1)+" UNDEC"+ list1.get(2));
            for(int i=0; i<num; i++) {
                System.out.println("********IN************"+i+"*************");
                int subnum = labels[i].length;

                boolean xnoLabel = true; // x not in Label
                if(in.contains(args[i])|| out.contains(args[i]) || undec.contains(args[i])){

                    xnoLabel = false;
                }
                boolean yinOut = true;
                for(int subi=0; subi<subnum; subi++){

                    if(!"".equals(labels[i][subi])&&!out.contains(labels[i][subi])){
                        yinOut = false;
                        break;
                    }
                }
                boolean xnoAtt= "".equals(labels[i][0]); // x no attack  .contains(args[0][i])
                System.out.println("ss: "+ss);
                //System.out.println(xnoLabel+"--"+yinOut+"--"+xnoAtt);
                if (xnoLabel) { // UNDEC
                    if(xnoAtt){
                        System.out.println(args[i] + "   is  IN ");
                        in2.add(args[i]);
                    }else{
                        if(yinOut){
                            System.out.println(args[i] + "   is  IN ");
                            in2.add(args[i]);
                        }
                    }
                }
            }

            for(int j=0; j<num; j++) {
                System.out.println("********OUT************"+j+"*************");
                boolean xnoLabel2 = true; // x not in Label
                if(in.contains(args[j])|| out.contains(args[j]) || undec.contains(args[j])){
                    xnoLabel2 = false;
                }// x not in Label
                int subnum2 = labels[j].length;
                boolean yinIn = false; // y in IN
                for(int subj=0; subj<subnum2; subj++){
                    // y in OUT
                    if(in2.contains(labels[j][subj])){
                        yinIn = true;
                        break;
                    }
                }

                boolean xhasAtt= ss.contains(args[j]); // x has attack
                if (xnoLabel2 && yinIn ) { // UNDEC
                    //System.out.println(l3[0].length);
                    System.out.println(args[j] + "   is   OUT   ");
                    out2.add(args[j]);
                }
            }

            g--;
            c++;
        }while(equalArray(list1,list2)); //equalArray(list1,list2));  g>=2
        System.out.println("----------- UNDEC-------"+list1.get(2));
        for (String arg : args) {
            boolean notIn = in.contains(arg);
            boolean notOut = out.contains(arg);
            if (!notIn && !notOut) {
                System.out.println(arg + "is  UNDEC  ");
                list1.get(2).add(arg);
                //list2.get(2).add(args[0][s]);
            }
        }
        System.out.println("The final result is: ");
        System.out.println("IN: "+list1.get(0)+"OUT: "+list1.get(1)+" UNDEC"+ list1.get(2));

        //System.out.println("num:"+num+"  in:"+in.size()+" out:"+out.size()+" undec:"+undec.size());
        String[][] lr = new String[2][num];
        int ins =in.size();
        int outs = out.size();
        for(int s=0; s<num; s++){
            System.out.println(s);
            if(s< ins){
                lr[0][s]=in.get(s);
                lr[1][s]="IN";
            }else if(s<(ins+outs)){
                System.out.println("out:--"+(1+s-ins));
                lr[0][s]=out.get(s-ins);
                lr[1][s]="OUT";
            }else {
                lr[0][s]=undec.get(s-ins-outs);
                lr[1][s]="UNDEC";
            }
            System.out.println(lr[0][s]+"---"+lr[1][s]);
        }

        return lr;
    }

    public static void main(String[] args) {

        /*String[] arg = {"0","1","2","3"};
        System.out.println(arg.length);
        int alength = arg.length;
        String[][] lab= {{"1","3"},{"0"},{""},{""}}; // 被攻击
        System.out.println(lab[0].length);*/
        //G_Labelling g = new G_Labelling();
        //String [][] s =g.ground(arg,lab);


    }
}
