package lotto.controller;

import lotto.model.*;

import java.util.List;

public class PrizeController {
    PrizeMoney prizeMoney;
    WinnerLotto winnerLotto = new WinnerLotto();
    public void comparePrizeNumToLottoNum(PrizeLotto prizeLotto , UserLotto userLotto){
        //배열을 생성해서 로또마다 몇개 맞췄는지 배열에 인덱스로 장
        //예로 3개 맞으면 인덱스 3을 하나 증
        int[] arr = new int[8];
        for(Lotto lo : userLotto.getUsersLotto()){
            arr[compareLottoAndPrize(lo, prizeLotto)]++;
        }
        winnerLotto.setLottoPrizeCount(arr);
        for(int i : winnerLotto.getLottoPrizeCount()){
            System.out.print(i+" ");
        }
    }
    public int compareLottoAndPrize(Lotto lo,PrizeLotto prizeLotto ){
        int count =0;
        List<Integer> prizeLottoNum = prizeLotto.getPrizeNumbers();
        int bonusNum = prizeLotto.getBonusNum();
        for(int i: prizeLottoNum){
            if(lo.getNumbers().contains(i)){
                count++;
            }
        }
        if(count == 5){
            if(lo.getNumbers().contains(bonusNum)){
                count =7;
            }
        }
        return count;
    }
}
