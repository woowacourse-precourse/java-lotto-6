package lotto;

import java.util.*;

public class InputValidator {
    public int validateAndReturnLottoInput(String inputMoney) throws IllegalArgumentException {
        int money = Integer.parseInt(inputMoney);
        validateMoneyUnit(money);
        return money;
    }
    private void validateMoneyUnit(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("PURCHASE MONEY MUST BE POSITIVE!");
        } else if ((money % 1000) != 0) {
            throw new IllegalArgumentException("OUT OF UNIT!");
        }
    }

    public List<Integer> validateAndReturnWinningNumber(String numberInput) throws IllegalArgumentException {
        List<Integer> winningNumbers = new ArrayList<>(parseWinningNumber(numberInput));
        if (checkDuplicateNumber(winningNumbers) && checkWinNumberSize(winningNumbers) && validateCorrectRangeWinNumbers(winningNumbers)) {
            Collections.sort(winningNumbers);
            return winningNumbers;
        }
        return null;
    }
    private boolean checkDuplicateNumber(List<Integer> winNumbers) {
        if (winNumbers.size() != new HashSet<>(winNumbers).size()) {
            throw new IllegalArgumentException("DUPLICATE NUMBER EXIST!");
        }
        return true;
    }
    private boolean checkWinNumberSize(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("OUT OF WINNING NUMBER SIZE!");
        }
        return true;
    }
    private boolean validateCorrectRangeWinNumbers(List<Integer> winNumbers) {
        for (Integer number: winNumbers) {
            if (!isCorrectNumber(number)) {
                throw new IllegalArgumentException("OUT OF RANGE NUMBER!");
            }
        }
        return true;
    }
    private boolean isCorrectNumber(int number) {
        return number >= 1 && number <= 45;
    }

    private List<Integer> parseWinningNumber(String numberInput) {
        return Arrays.stream(numberInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
