package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final Integer MONEY_UNIT = 1000;
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;

    public Boolean isNumericValidator(String number){
        try {
            Integer parsedNumber = Integer.parseInt(number);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public Boolean isThousandUnitValidator(Integer money){
        return (money % MONEY_UNIT == 0);
    }

    public Boolean isInRangeValidator(Integer number){
        return (number >= MINIMUM_NUMBER && number <= MAXIMUM_NUMBER);
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
