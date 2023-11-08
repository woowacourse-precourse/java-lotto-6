package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final int WINNING_NUMBER_SIZE = 6;
    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;

    private final List<Integer> winningNumbers;

    public WinningNumber(String winningNumInput) {
        String[] winningNums = winningNumInput.split(",");
        validateWinningNumbers(winningNums);

        this.winningNumbers = Arrays.stream(winningNums)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public boolean isContainLottoNumber(int number) {
        return winningNumbers.contains(number);
    }

    private void validateWinningNumbers(String[] winningNumInput) {
        validateIsNumber(winningNumInput);
        validateIsPositive(winningNumInput);
        validateWinningNumSize(winningNumInput);
        validateWinningNumRange(winningNumInput);
        validateIsDuplicated(winningNumInput);
    }

    private void validateIsNumber(String[] winningNumInput) {
        for (String winningNum : winningNumInput) {
            try {
                Integer.parseInt(winningNum);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("당첨 번호에 숫자 외의 문자와 공백은 포함될 수 없습니다. 1부터 45까지의 숫자를 입력해주세요.");
            }
        }
    }

    private void validateIsPositive(String[] winningNumInput) {
        for (String winningNum : winningNumInput) {
            int num = Integer.parseInt(winningNum);
            if (num <= 0) {
                throw new IllegalArgumentException("당첨 번호에 음수는 포함될 수 없습니다. 1부터 45까지의 숫자를 입력해주세요.");
            }
        }
    }

    private void validateWinningNumSize(String[] winningNumInput) {
        if (winningNumInput.length != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateWinningNumRange(String[] winningNumInput) {
        for (String winningNum : winningNumInput) {
            int number = Integer.parseInt(winningNum);
            if (number < MIN_WINNING_NUMBER || number > MAX_WINNING_NUMBER) {
                throw new IllegalArgumentException("당첨 번호는 " + MIN_WINNING_NUMBER + "부터 "
                        + MAX_WINNING_NUMBER + "까지의 숫자만 가능합니다.");
            }
        }
    }

    private void validateIsDuplicated(String[] winningNumInput) {
        Set<String> distinctNumbers = new HashSet<>(Arrays.asList(winningNumInput));
        if (winningNumInput.length != distinctNumbers.size()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }
}
