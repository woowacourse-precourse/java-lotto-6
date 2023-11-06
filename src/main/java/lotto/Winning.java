package lotto;

import lotto.constant.Constant;

import java.util.ArrayList;
import java.util.List;

import static lotto.UserInput.*;
import static lotto.common.Common.strToInt;

public class Winning {
    List<Integer> listVal;
    int bonus;

    private void validBonus(List<Integer>listNum, int bonus){
        validNum(bonus);

        if(listNum.contains(bonus)) {
            throw new IllegalArgumentException(
                    Constant.error + Constant.existNumber
            );
        }
    }

    private void validNum(int num){
        if(num < 1 || num > 45) {
            throw new IllegalArgumentException(
                    Constant.error + Constant.rangeOver
            );
        }
    }

    private void validArray(String[] array){
        if(array.length != 6) {
            throw new IllegalArgumentException(
                    Constant.error + Constant.lengthOver
            );
        }
    }

    public Winning(){
        String[] arrWinning = inputNumbers().split(",");
        List<Integer> listNum = new ArrayList<>();

        validArray(arrWinning);
        for (String s : arrWinning) {
            int num = strToInt(s);
            validNum(num);
            listNum.add(num);
        }
        int bonus = strToInt(inputBonus());
        validBonus(listNum, bonus);
        this.listVal = listNum;
        this.bonus = bonus;
    }
}
