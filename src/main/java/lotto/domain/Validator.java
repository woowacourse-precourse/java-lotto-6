package lotto.domain;

import java.util.List;
import lotto.errors.ErrorMessage;

public class Validator {

     protected void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LUCKY_NUMBER_COUNT.getMessage());
        }
    }

    protected void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NO_DUPLICATED_NUMBER.getMessage());
        }
    }

    protected void validateRangeOfNumbers(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
        }
    }

    protected void validateRangeOfNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_RANGE.getMessage());
        }
    }

    protected int parseInt(String cost){
        try {
            return Integer.parseInt(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
        }
    }

    protected void isSmallerthanZero(int cost){
        if (cost<=0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SMALLER_THAN_ZERO.getMessage());
        }
    }

    protected void calculateNumberOfLottos(int cost){
        if (cost%1000!=0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_COST.getMessage());
        }
    }
}
