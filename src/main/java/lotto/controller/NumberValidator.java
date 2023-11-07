package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberValidator {
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
}
