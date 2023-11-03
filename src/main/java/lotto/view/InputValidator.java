package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Boolean isNotOverlapSixValidator(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(Integer number : numbers){
            if(!uniqueNumbers.add(number)){
                return false;
            }
        }
        return true;
    }

    public Boolean isNotOverlapBonusValidator(List<Integer> numbers, Integer bonusNumber){
        return !numbers.contains(bonusNumber);
    }
}
