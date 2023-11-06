package lotto.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateIsSixNumbers(List<String> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력하셔야 합니다.");
        }
    }

    private static void validateIsNumberInRange(List<String> numbers) {
        for(String number : numbers) {
            boolean IsNumberInRange = (Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 45);
            if(!IsNumberInRange) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
