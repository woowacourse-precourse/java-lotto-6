package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Paper {
    public List<Integer> originNumbers;
    public List<Integer> numbers;
    private int correspondNumber;
    private int winMoney;

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
        if(cnt==5 && numbers.contains(bonusNumber)){
            correspondNumber = 6;
            return;
        }
        if(cnt==6){
            correspondNumber = 7;
        }

    }

    public void checkWinMoney(){
        if(correspondNumber==3) {
            winMoney=5000;
            return;
        }
        if(correspondNumber==4) {
            winMoney=50000;
            return;
        }
        if(correspondNumber==5) {
            winMoney=1500000;
            return;
        }
        if(correspondNumber==7) {
            winMoney=20000000;
            return;
        }
        if(correspondNumber==6) {
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
