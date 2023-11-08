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
        checkDuplicateNumber(winningNumbers);
        checkWinNumberSize(winningNumbers);
        validateCorrectRangeWinNumbers(winningNumbers);
        Collections.sort(winningNumbers);
        return winningNumbers;
    }
    private void checkDuplicateNumber(List<Integer> winNumbers) {
        if (winNumbers.size() != new HashSet<>(winNumbers).size()) {
            throw new IllegalArgumentException("DUPLICATE NUMBER EXIST!");
        }
    }
    private void checkWinNumberSize(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("OUT OF WINNING NUMBER SIZE!");
        }
    }
    private void validateCorrectRangeWinNumbers(List<Integer> winNumbers) {
        for (Integer number: winNumbers) {
            validateCorrectNumber(number);
        }
    }
    private void validateCorrectNumber(int number) {
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("OUT OF RANGE NUMBER!");
        }
    }

    private List<Integer> parseWinningNumber(String numberInput) {
        return Arrays.stream(numberInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int validateAndReturnBonusNumber(String s, List<Integer> winningNumbers) throws IllegalArgumentException {
        int bonusNumber = Integer.parseInt(s);
        validateCorrectNumber(bonusNumber);
        validateExistNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private void validateExistNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("ALREADY EXIST!");
        }
    }
}
