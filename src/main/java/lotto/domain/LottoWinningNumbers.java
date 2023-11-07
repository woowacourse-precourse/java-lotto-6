package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers;

    public LottoWinningNumbers(String numbersString) {
        validateOnlyPositiveWinningNumbers(numbersString);
        List<Integer> winningNumbers = convertToList(numbersString);
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void validateOnlyPositiveWinningNumbers(String numbersString) {
        if (!numbersString.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 입력되어야 합니다.");
        }
    }

    private List<Integer> convertToList(String numbersString){
        return Arrays.stream(numbersString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumberRange(winningNumbers);
        validateWinningNumberDuplicate(winningNumbers);
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개가 입력되어야 합니다.");
        }
    }

    private void validateWinningNumberRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(number -> number <= 0 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateWinningNumberDuplicate(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 될 수 없습니다.");
        }
    }
}
