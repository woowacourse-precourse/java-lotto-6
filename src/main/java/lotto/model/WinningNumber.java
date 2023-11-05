package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WinningNumber {

    private static final Pattern winningNumberInputPattern = Pattern.compile(
            "\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}");
    private List<Integer> winningNumbers;

    public void inputWinningNumber(String input) {
        validateWinningNumber(input);
        List<Integer> inputNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt).toList();
        validateNumberRange(inputNumbers);
        validateDuplication(inputNumbers);
        this.winningNumbers = inputNumbers;
    }

    private static void validateDuplication(List<Integer> inputNumbers) {
        Set<Integer> validateNumbers = new HashSet<>(inputNumbers);
        if (validateNumbers.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해주세요.");
        }
    }

    private static void validateNumberRange(List<Integer> inputNumbers) {
        for (Integer inputNumber : inputNumbers) {
            if (inputNumber < 1 || inputNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또는 1부터 45까지의 숫자만 사용됩니다.");
            }
        }
    }

    private static void validateWinningNumber(String input) {
        if (!winningNumberInputPattern.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 당첨 번호 입력 양식입니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
