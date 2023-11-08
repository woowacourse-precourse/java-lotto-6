package lotto.validator;

import lotto.InputData;

import java.util.List;

public class BonusValidation {

    final String numberRange = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";

    final String numberError = "[ERROR] 1~45 사이의 숫자를 입력하십시오.";

    final String bonusDuplicateError = "[ERROR] 보너스 숫자는 기존의 숫자와 중복될 수 없습니다.";

    public void bonusValidate(List<String> winNumber,String input){
        checkBonusNumber(input);
        checkBonusDuplicate(winNumber,input);
    }


    private void checkBonusNumber(String input){
        if(!input.matches(numberRange))
            throw new IllegalArgumentException(numberError);
    }

    private void checkBonusDuplicate(List<String> winNumber,String input){
        if(winNumber.contains(input)){
            throw new IllegalArgumentException(bonusDuplicateError);
        }

    }

}





