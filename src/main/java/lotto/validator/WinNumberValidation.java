package lotto.validator;

import lotto.InputData;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WinNumberValidation {

    final String condition = "^[0-9]+$";

    final String numberRange = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";              //1~9, 10~39, 40~45를 허용
    final String numberError = "[ERROR]숫자를 입력하십시오.";
    final String countError = "[ERROR]로또 당첨 번호는 6개 입니다.";
    final String rangeError = "[ERROR]로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    final String duplicateError = "[ERROR]로또 번호는 중복 될 수 없습니다.";

    public void winValidate(String input){
        checkWinCount(input);
        checkWinNumber(input);
        checkDuplicate(input);
    }
    private void checkWinCount(String input){
        String[] lottoCount = input.split(",");
        if(lottoCount.length!=6){
            throw new IllegalArgumentException(countError);
        }
    }

    private void checkWinNumber(String input){
        String[] lottonumber = input.split(",");
        for(String number : lottonumber) {
            if (!number.matches(condition))
                throw new IllegalArgumentException(numberError);
            if(!number.matches(numberRange))
                throw new IllegalArgumentException(rangeError);
        }
    }

    private void checkDuplicate(String input){
        InputData inputData = new InputData();
        List<String> checknumber = inputData.lottoMake(input);
        for(String temp : checknumber){
            if(Collections.frequency(checknumber,temp)>1){
                throw new IllegalArgumentException(duplicateError);
            }
        }
    }



}
