package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberValidator {
    public int buyLottoMoneyValidator(String buyMoney) {
        int money;
        try {
            money = Integer.parseInt(buyMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 숫자가 아닌 문자가 들어왔습니다.");
        }
        return numberOfLotto(money);
    }
    public int numberOfLotto(int money){
        if(validateMoneyOfLotto(money)){
            return money / 1000;
        }
        throw new IllegalArgumentException("[ERROR] 돈이 1000원으로 나누어 떨어지지 않습니다.");
    }
    public boolean validateMoneyOfLotto(int money){
        if(money % 1000 ==0){
            return true;
        }
        return false;
    }

    public List<Integer> prizeLottoNumValidator(String prizeNums){
        List<Integer> prizeLottoNums;
        String removeEmptyPrizeNum = prizeNums.replace(" ","");
        List<String> prizeNumArr = Arrays.asList(removeEmptyPrizeNum.split(","));

        return prizeNumStringToInt(prizeNumArr);
    }

    public List<Integer> prizeNumStringToInt(List<String> prizeNumStr){
        List<Integer> prizeNumInt = new ArrayList<>();
        for(String s: prizeNumStr){
            try {
                prizeNumInt.add(Integer.parseInt(s));
            } catch (NumberFormatException e){
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 숫자가 아닌 문자가 들어왔습니다.");
            }
        }

        return prizeNumInt;
    }

    public int rangePrizeNum(int num){
        if(num >45 || num<1){
            throw new IllegalArgumentException("[ERROR] 숫자 범위는 1~45입니다.");
        }
        return num;
    }
}
