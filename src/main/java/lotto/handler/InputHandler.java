package lotto.handler;

import lotto.exception.*;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public static final String COMMA = ",";
    public static final int LOTTO_PRICE = 1000;

    public int handlePurchaseAmount(String purchaseAmountInput) {
        validateNull(purchaseAmountInput);

        int purchaseAmount = parseInteger(purchaseAmountInput);

        validatePurchaseAmount(purchaseAmount);

        return purchaseAmount / LOTTO_PRICE;
    }

    public List<Integer> handleWinningNumbers(String winningNumbersInput) {
        String[] numbersInput = winningNumbersInput.split(COMMA);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberInput : numbersInput) {
            validateNull(numberInput);

            int winningNumber = parseInteger(numberInput);
            validateNumber(winningNumber);

            winningNumbers.add(winningNumber);
        }

        return winningNumbers;
    }

    public int handleBonusNumber(String bonusNumberInput, List<Integer> winningNumber) {
        validateNull(bonusNumberInput);

        int bonusNumber = parseInteger(bonusNumberInput);

        validateBonusNumber(bonusNumber, winningNumber);

        return bonusNumber;
    }

    private void validateNull(String input) {
        if (input == null || input.isBlank()) {
            throw new NullInputException();
        }
    }

    private int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new ParseException();
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }

    private void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new InvalidNumberException();
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        validateNumber(bonusNumber);

        if (winningNumber.contains(bonusNumber)) {
            throw new InvalidBonusNumberException();
        }
    }
}
