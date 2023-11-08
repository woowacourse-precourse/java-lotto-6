package util;

import lotto.LottoGenerator;

import java.util.List;
import java.util.Set;

import static lotto.LottoException.*;
import static lotto.LottoGenerator.LIMIT_NUMBER_COUNT;
import static view.ViewException.*;

public class NumberValidator {

    public static boolean isValidNumber(List<Integer> numbers){
        return isSuitableLength(numbers)
                && isDistinct(numbers)
                && isOrdered(numbers)
                && isInRange(numbers);
    }

    public static boolean isOrdered(List<Integer> numbers){
        int prevValue = numbers.get(0);
        for(int i=1; i<numbers.size(); i++){
            int curValue = numbers.get(i);
            if(prevValue > curValue){
                throw new IllegalArgumentException(LOTTO_NUMBER_NOT_ORDERED.getMessage());
            }
            prevValue = curValue;
        }
        return true;
    }
    public static boolean isSuitableLength(List<Integer> numbers){
        if(numbers.size() != LIMIT_NUMBER_COUNT){
            throw new IllegalArgumentException(LOTTO_NUMBER_INVALID_SIZE.getMessage());
        }
        return true;
    }

    public static boolean isDistinct(List<Integer> numbers){
        if(Set.copyOf(numbers).size() != numbers.size()){
            throw new IllegalArgumentException(LOTTO_HAS_DUPLICATE_NUM.getMessage());
        }
        return true;
    }

    public static boolean canGenerateBonusNumber(List<Integer> numbers, int bonusNumber){
        return isInRange(numbers)
                && isNotDuplicateWinnerNumbers(numbers, bonusNumber);
    }

    public static boolean isInRange(List<Integer> numbers){
        for(int number : numbers){
            if(!numberIsInRange(number)){
                throw new IllegalArgumentException(LOTTO_NUMBER_INVALID_RANGE.getMessage());
            }
        }
        return true;
    }

    public static boolean isNotDuplicateWinnerNumbers(List<Integer> numbers, int bonusNumber){
        for(int number : numbers){
            if(number == bonusNumber){
                throw new IllegalArgumentException(LOTTO_BOUNS_NUM_IS_DUPLECATE.getMessage());
            }
        }
        return true;
    }

    public static boolean isNumeric(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean canParseToMoney(long money){
        return isPositive(money)
                && overThousand(money)
                && lowerThanMaxNumber(money);
    }

    public static boolean canParseToLong(String input){
        try{
            Long.parseLong(input);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean isPositive(long number){
        if(number <=0){
            throw new IllegalArgumentException(INPUT_SHOULD_BE_POSITIVE.getMessage());
        }
        return true;
    }

    public static boolean overThousand(long number){
        if(number<1000){
            throw new IllegalArgumentException(INPUT_SHOULD_BE_OVER_THOUSAND.getMessage());
        }
        return true;
    }

    public static boolean lowerThanMaxNumber(long number){
        if(number >= Integer.MAX_VALUE){
            throw new IllegalArgumentException(INPUT_SHOULD_BE_LOWER_THAN_INT_MAX.getMessage());
        }
        return true;
    }

    public static boolean canDivide(long number, int operand){
        try{
            long result = number / operand;
        }catch(ArithmeticException e){
            return false;
        }
        return true;
    }

    public static boolean numberIsInRange(int number){
        return number>= LottoGenerator.MIN_NUMBER_RANGE
                && number<= LottoGenerator.MAX_NUMBER_RANGE;
    }


}
