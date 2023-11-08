package lotto.validator;

import lotto.validator.errormessage.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class ValidateLotto {

    public static void validateLotto(List<Integer> numbers){
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_SIZE.getMessage());
        }
    }

    private static void validateDuplication(List<Integer> numbers){
        HashSet set=new HashSet();
        for(Integer number:numbers){
            if(hasDuplication(set,number)){
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
            }
        }
    }

    private static boolean hasDuplication(HashSet set, Integer number){
        if(!set.add(number)){
            return true;
        }
        return false;
    }
}
