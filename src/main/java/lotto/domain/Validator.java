package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.exception.LottoExceptionList.NUMBERS_DUPLICATE_ERROR;
import static lotto.domain.exception.LottoExceptionList.NUMBERS_NOT_PURE_ERROR;

public class Validator {

    public Validator(){}

    public void validateNumbersDuplicate(List<Integer> numbers){
        Set<Integer> numbersDuplicateCheck = new HashSet<>(numbers);
        if (numbersDuplicateCheck.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_ERROR.getMessage());
        }
    }

    public void validateNumbersPure(String numbers){
        char temp;
        for (int i = 0; i < numbers.length(); i++){
            temp = numbers.charAt(i);
            if (!Character.isDigit(temp)) {
                throw new IllegalArgumentException(NUMBERS_NOT_PURE_ERROR.getMessage());
            }
        }
    }
}
