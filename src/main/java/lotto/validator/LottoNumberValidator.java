package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    final static int LOTTO_NUMBER_COUNT = 6;
    final static int MIN_LOTTO_NUMBER = 1;
    final static int MAX_LOTTO_NUMBER = 45;
    final static int MIN_PURCHASE_COST = 1000;
    final static int MAX_PURCHASE_COST = 100000;
    public static boolean hasDuplicateNumbers(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return uniqueNumbers.size()==LOTTO_NUMBER_COUNT;
    }

    public static boolean validateLottoNumbersRange(List<Integer> numbers){
        for (Integer number : numbers){
            if(number<0 || number>45){
                return false;
            }
        }
        return true;
    }

    public static boolean validateNumberRange(int value, int min, int max){
        if(value<min || value>max){
            return false;
        }
        return true;
    }

    public static boolean isInteger(String inputMessage){
        try{
            Integer.parseInt(inputMessage);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
