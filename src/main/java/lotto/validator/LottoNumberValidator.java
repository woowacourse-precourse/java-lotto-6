package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {
    final static int lottoNumberCount = 6;
    public static boolean hasDuplicateNumbers(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return uniqueNumbers.size()==lottoNumberCount;
    }

    public static boolean validateNumberRange(List<Integer> numbers){
        for (Integer number : numbers){
            if(number<0 || number>45){
                return false;
            }
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
