package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {
    public void validate(String winningNumbers) {
        isBlank(winningNumbers);
        isNotValidWinningNumbersPattern(winningNumbers);
        List<Integer> splitWinningNumbers = splitWinningNumbers(winningNumbers);
        containsInvalidRangeNumberInWinningNumbers(splitWinningNumbers);
        hasDuplicatesInWinningNumbers(splitWinningNumbers);
    }

    private void isBlank(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력하세요. 값이 null 또는 빈 값일 수 없습니다.");
        }
    }

    private void isNotValidWinningNumbersPattern(String winningNumbers) {
        if (!winningNumbers.matches("^(\\d+(,\\d+)*)?$")) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자를 ,로 구분하여 입력해 주세요. ex)1,2,3,4,5,6");
        }
    }

    private List<Integer> splitWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void containsInvalidRangeNumberInWinningNumbers(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber <= 0 || 45 < winningNumber) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 1에서 45사이의 숫자를 입력해야 합니다.");
            }
        }
    }

    private void hasDuplicatesInWinningNumbers(List<Integer> winningNumbers) {
        if (isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복되지 않은 숫자들로 입력해야 합니다.");
        }
    }

    private boolean isDuplicate(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .distinct()
                .count() < winningNumbers.size();
    }
}
