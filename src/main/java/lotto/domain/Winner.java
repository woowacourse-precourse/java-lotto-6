package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winner {
    public ArrayList<Integer> ConfirmLotto(ArrayList<Integer>[] YourNumber, ArrayList<Integer> lotto, Integer Bonus){
        //중복된숫자만큼과 같은 인덱스에 count, 5+1(bouns) 인 경우 index 7에 저장
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0));
        Integer rank;
        Integer value;
        for(int i=0; i<YourNumber.length; i++){
            rank = checkDuplicate(YourNumber[i],lotto);
            if(rank==5&&YourNumber[i].contains(Bonus)){
                value = result.get(7);
                value++;
                result.set(7,value);
            }
            else{
                value = result.get(rank);
                value++;
                result.set(rank,value);
            }
        }

        return result;
    }

    public Integer checkDuplicate(ArrayList<Integer> arrA, ArrayList<Integer> arrB){
        Integer count=0;
        for(int i=0; i<arrA.size(); i++){
            if(arrA.contains(arrB.get(i))){
                count++;
            }
        }
        return count;
    }

    public void PrintResult(ArrayList<Integer> result){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개",result.get(3));
        System.out.println();
        System.out.printf("4개 일치 (50,000원) - %d개",result.get(4));
        System.out.println();
        System.out.printf("5개 일치 (1,500,000원) - %d개",result.get(5));
        System.out.println();
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",result.get(7));
        System.out.println();
        System.out.printf("6개 일치 (2,000,000,000원) - %d개",result.get(6));
        System.out.println();
    }

}
