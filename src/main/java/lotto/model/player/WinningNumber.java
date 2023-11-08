package lotto.model.player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;
import lotto.constant.UnitNumber;

public class WinningNumber {
    private static List<Integer> winningNumber;
    private static final String COMMA = ",";

    public WinningNumber(String numbers) {
        List<String> splitNumber = splitNumber(numbers);
        validate(splitNumber);
        winningNumber = splitNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<String> splitNumber(String numbers) {
        return Arrays.stream(numbers.split(COMMA))
                .collect(Collectors.toList());
    }

    private static void validate(List<String> numbers) {
        validateIsIntegerNumber(numbers);
        validateIsSixNumbers(numbers);
        validateIsDistinctNumbers(numbers);
        validateIsNumberInRange(numbers);
    }

    private static void validateIsIntegerNumber(List<String> numbers) {
        for(String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
        }
    }

    private static void validateIsSixNumbers(List<String> numbers) {
        if(numbers.size() != UnitNumber.WINNING_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_COUNT.getMessage());
        }
    }

    private static void validateIsDistinctNumbers(List<String> numbers) {
        if(numbers.stream().distinct().toList().size() != UnitNumber.WINNING_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING.getMessage());
        }
    }

    private static void validateIsNumberInRange(List<String> numbers) {
        for(String number : numbers) {
            boolean IsNumberInRange = (Integer.parseInt(number) >= UnitNumber.LOTTO_MIN_NUMBER.getNumber()
                    && Integer.parseInt(number) <= UnitNumber.LOTTO_MAX_NUMBER.getNumber());
            if(!IsNumberInRange) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
