package com.example.dilay.myapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuestionGenarator {

    public static String Genearete(int numCount,int oparatorCount){
        String finalExpr="";
        ArrayList<String> operatorList=new ArrayList<>();
        ArrayList<Integer>numberList=new ArrayList<>();
        operatorList.add(0,"+");
        operatorList.add(1,"-");
        operatorList.add(2,"*");
        operatorList.add(3,"/");
        ///=================================================================//






        ///=================================================================//
        for(int i=0;i<numCount;i++){
            numberList.add(new Random().nextInt(9)+1);
        }
          int dice =new Random().nextInt(oparatorCount);
        if(numCount==4){
          finalExpr=String.valueOf(numberList.get(0))+String.valueOf(numberList.get(1))+operatorList.get(new Random().nextInt(oparatorCount))+String.valueOf(numberList.get(2))+String.valueOf(numberList.get(3))+operatorList.get(new Random().nextInt(oparatorCount))+operatorList.get(new Random().nextInt(oparatorCount));
        }else if(numCount==5){
            finalExpr=String.valueOf(numberList.get(0))+String.valueOf(numberList.get(1))+operatorList.get(new Random().nextInt(oparatorCount))+String.valueOf(numberList.get(2))+String.valueOf(numberList.get(3))+operatorList.get(new Random().nextInt(oparatorCount))+operatorList.get(new Random().nextInt(oparatorCount))+String.valueOf(numberList.get(4))+operatorList.get(new Random().nextInt(oparatorCount));
        }else if(numCount==7){
            finalExpr=String.valueOf(numberList.get(0))+String.valueOf(numberList.get(1))+operatorList.get(new Random().nextInt(oparatorCount))+String.valueOf(numberList.get(2))+String.valueOf(numberList.get(3))+operatorList.get(new Random().nextInt(oparatorCount))+operatorList.get(new Random().nextInt(oparatorCount))+String.valueOf(numberList.get(4))+operatorList.get(new Random().nextInt(oparatorCount))+String.valueOf(numberList.get(5))+String.valueOf(numberList.get(6))+operatorList.get(new Random().nextInt(oparatorCount))+operatorList.get(new Random().nextInt(oparatorCount));
        }


        return finalExpr;
    }


    public static String [] GenerateTreeQuestion(int numCount){
        BinarySearchTree tree = new BinarySearchTree();
        ArrayList<Integer>numberListBST=new ArrayList<>();
        String question="";
        String [] results =new String[4];


        for(int i=0;i<numCount;i++){
            numberListBST.add(new Random().nextInt(100)+1);
        }

        for(int i=0;i<numCount;i++){
            tree.insert(numberListBST.get(i));
            question=question+String.valueOf(numberListBST.get(i))+" ";
        }
        tree.inorder();
        tree.preorder();
        tree.postorder();

        results[0]=question;
        results[1]=tree.preOrderAns;
        results[2]=tree.inOrderAns;
        results[3]=tree.postOrderAns;
        return results;

    }

}
