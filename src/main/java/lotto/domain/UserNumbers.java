package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumbers {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> userNumbers;

    private UserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public static UserNumbers of(String winningNumbers) {
        validateWinningNumbers(winningNumbers);
        List<Integer> res = parseWinningNumber(winningNumbers);
        return new UserNumbers(res);
    }

    private static List<Integer> parseWinningNumber (String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static void validateWinningNumbers(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("로또 번호를 입력해주세요.");
        }
        if (!winningNumbers.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("로또 번호는 숫자만 입력 가능합니다.");
        }
        if (Integer.parseInt(winningNumbers) < MIN_NUMBER || Integer.parseInt(winningNumbers) > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
        }
    }
}
