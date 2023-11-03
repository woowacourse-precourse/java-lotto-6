package lotto.handler;

import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.InvalidWinningNumberException;
import lotto.exception.NullInputException;
import lotto.exception.ParseException;

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
            validateWinningNumber(winningNumber);

            winningNumbers.add(winningNumber);
        }

        return winningNumbers;
    }

    private void validateNull(String lottoQuantity) {
        if (lottoQuantity == null || lottoQuantity.isBlank()) {
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

    private void validateWinningNumber(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new InvalidWinningNumberException();
        }
    }
}
