package lotto.model.player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;

public class WinningNumber {
    private static List<Integer> winningNumber;

    public WinningNumber(String numbers) {
        List<String> splitNumber = splitNumber(numbers);
        validate(splitNumber);
        winningNumber = splitNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<String> splitNumber(String numbers) {
        return Arrays.stream(numbers.split(","))
                .collect(Collectors.toList());
    }

    private static void validate(List<String> numbers) {
        validateIsIntegerNumber(numbers);
        validateIsSixNumbers(numbers);
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
        if(numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_COUNT.getMessage());
        }
    }

    private static void validateIsNumberInRange(List<String> numbers) {
        for(String number : numbers) {
            boolean IsNumberInRange = (Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 45);
            if(!IsNumberInRange) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
