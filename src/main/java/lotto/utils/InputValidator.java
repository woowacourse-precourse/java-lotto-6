package lotto.utils;

import java.util.List;

public class InputValidator {
    private static final int MIN_COST = 1000;
    private static final int MAX_COST = 100000;

    public void validatePurchaseCostInputView(String cost) {
        validateInputBlank(cost);
        validateInputInt(cost);
        validateCostOutOfSize(cost);
        validateCostInUnit(cost);
    }

    public void validateWinningNumberInputView(String number) {
        List<String> numberList = StringParser.splitString(number);
        validateInputBlank(number);
        validateWinningNumberSplitSize(numberList);
        validateWinningNumberDuplication(numberList);
        validateWinningNumberEach(numberList);
    }

    private void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[Error] 빈 값을 입력할 수 없습니다");
        }
    }

    private void validateInputInt(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[Error] 정수가 아닌 다른 문자는 입력할 수 없습니다");
        }
    }

    private void validateCostOutOfSize(String cost) {
        int intCost = Integer.parseInt(cost);
        if (intCost < MIN_COST || intCost > MAX_COST) {
            throw new IllegalArgumentException("[Error] 구매 금액은 1000원 이상 100,000원 이하로만 가능합니다");
        }
    }

    private void validateCostInUnit(String cost) {
        int intCost = Integer.parseInt(cost);
        if (intCost % MIN_COST != 0) {
            throw new IllegalArgumentException("[Error] 구매 금액은 1000원 단위로만 가능합니다");
        }
    }

    private void validateWinningNumberSplitSize(List<String> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 쉼표를 기준으로 당첨 번호 6개를 입력해 주세요");
        }
    }

    private void validateWinningNumberOutOfSize(String winningNumber) {
        int winningNumberToInt = StringParser.parseStringToInt(winningNumber);
        if (winningNumberToInt < 1 || winningNumberToInt > 45) {
            throw new IllegalArgumentException("[Error] 당첨 번호는 1부터 45까지의 숫자만 가능합니다");
        }
    }

    private void validateWinningNumberDuplication(List<String> winningNumbers) {
        List<String> distinctWinningNumbers = winningNumbers.stream().distinct().toList();
        if (winningNumbers.size() != distinctWinningNumbers.size()) {
            throw new IllegalArgumentException("[Error] 당첨 번호는 중복되어선 안됩니다");
        }
    }

    private void validateWinningNumberEach(List<String> winningNumbers) {
        for(String number : winningNumbers) {
            validateInputInt(number);
            validateWinningNumberOutOfSize(number);
        }
    }
}
