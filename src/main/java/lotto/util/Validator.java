package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.config.Config;
import lotto.view.ErrorView;

public class Validator {

    public static void isSize(List<Integer> numbers) {
        if(numbers.size() != Config.COUNT_LOTTO) {
            ErrorView.isSizeError();
        }
    }

    public static void isDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(int number : numbers) {
            if(uniqueNumbers.contains(number)) {
                ErrorView.isDuplicatedError();
            }
            uniqueNumbers.add(number);
        }
    }




}
