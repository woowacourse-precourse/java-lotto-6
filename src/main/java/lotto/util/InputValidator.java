package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final Integer MONEY_UNIT = 1000;
    private static final Integer MINIMUM_MONEY_STANDARD = 0;
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;

    public Boolean isNumericValidator(String number){
        try {
            Integer parsedNumber = Integer.parseInt(number);
            return true;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력은 숫자 형태여야 합니다.");
        }
    }

    public Boolean isThousandUnitValidator(Integer money){
        if(money % MONEY_UNIT != 0){
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1,000원 단위여야 합니다.");
        }
        return true;
    }

    public Boolean isMinimumValidator(Integer money){
        if(money <= MINIMUM_MONEY_STANDARD){
            throw new IllegalArgumentException("[ERROR] 입력 금액은 최소 0원 초과여야 합니다.");
        }
        return true;
    }

    public Boolean isInRangeValidator(Integer number){
        if(number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return true;
    }
    public Boolean isNotOverlapSixValidator(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(Integer number : numbers){
            if(!uniqueNumbers.add(number)){
                throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.(1)");
            }
        }
        return true;
    }

    public Boolean isNotOverlapBonusValidator(List<Integer> numbers, Integer bonusNumber){
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.(2)");
        }
        return true;
    }
}
