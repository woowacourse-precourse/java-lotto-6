package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoNum {

    public Integer lottoBuy(int price){
        int lottoBuyNum = price/1000;
        return lottoBuyNum;

    }



    public ArrayList<Integer>[] lottoList(int buyNum){
        ArrayList<Integer>[] lottoNumList = new ArrayList[buyNum];

        for(int i=0;i<buyNum;i++){
            lottoNumList[i] = new ArrayList<>();
            List<Integer> number = (Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(number);
            lottoNumList[i].addAll(number);
        }

        return lottoNumList;

    }
}
