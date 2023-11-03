package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputValidator {
    public Boolean isNumericValidator(String number){
        try {
            Integer parsedNumber = Integer.parseInt(number);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public Boolean isInRangeValidator(Integer number){
        return (number >= 1 && number <= 45);
    }

}
