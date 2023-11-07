package lotto.util.validate;

import static lotto.user.model.UserConstant.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lotto.util.error.CustomError;

public class UserValidate {
    public static void isTousand(int number){
        if(number % THOUSAND != 0)
            throw new IllegalArgumentException(CustomError.INPUT_IS_NOT_THOUSAND.getError());
    }

    public static void checkNumberCount(List<Integer> numbers){
        if(numbers.size() != MAX_INPUT_NUMBER)
            throw new IllegalArgumentException(CustomError.INPUT_MAX_NUMBER.getError());
    }

    public static void checkNumberRange(int number){
        if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
            throw new IllegalArgumentException(CustomError.INPUT_NUMBER_RANGE.getError());
    }

    public static void checkDuplicate(List<Integer> numbers){
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : numbers){
            map.put(number, 1);
        }
        Set<Integer> keySet = map.keySet();
        if(keySet.size() != MAX_INPUT_NUMBER)
            throw new IllegalArgumentException(CustomError.NUMBER_DUPLICATE.getError());
    }
}
