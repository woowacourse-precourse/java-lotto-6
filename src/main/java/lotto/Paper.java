package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static lotto.MatchingNumber.Three;

public class Paper {
    public List<Integer> originNumbers;
    public List<Integer> numbers;
    public int correspondNumber;
    public int winMoney;

    public Paper(){
        pickLottoNumber();
    }

    public void pickLottoNumber(){
        originNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers=new ArrayList<>(originNumbers);
        Collections.sort(numbers);
    }

    public List<Integer> getNumber(){
        return numbers;
    }

    public void checkCorrespondNum(List<Integer> winNumbers, int bonusNumber){
        int cnt=0;
        for(int i : winNumbers){
            if(numbers.contains(i)){
                cnt++;
            }
        }
        if(cnt==MatchingNumber.Five.getValue() && numbers.contains(bonusNumber)){
            correspondNumber = MatchingNumber.FiveBonus.getValue();
            return;
        }
        if(cnt==6){
            correspondNumber = MatchingNumber.Six.getValue();
            return;
        }
        correspondNumber=cnt;
    }
    //3~7 enum화
    public void checkWinMoney(){
        if(correspondNumber== MatchingNumber.Three.getValue()) {
            winMoney=5000;
            return;
        }
        if(correspondNumber==MatchingNumber.Four.getValue()) {
            winMoney=50000;
            return;
        }
        if(correspondNumber==MatchingNumber.Five.getValue()) {
            winMoney=1500000;
            return;
        }
        if(correspondNumber==MatchingNumber.Six.getValue()) {
            winMoney=20000000;
            return;
        }
        if(correspondNumber==MatchingNumber.FiveBonus.getValue()) {
            winMoney=30000000;
        }
    }

    public int getCorrespondNum(){
        return correspondNumber;
    }
    public int getWinMoney(){
        return winMoney;
    }

    public void printPaperNumbers(){
        System.out.println(numbers);
    }


}
