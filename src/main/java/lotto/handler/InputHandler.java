package lotto.handler;

import lotto.exception.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputHandler {

    public static final String COMMA = ",";
    public static final int LOTTO_PRICE = 1000;
    public static final int MIN_PURCHASE_AMOUNT = 0;
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;

    public int handlePurchaseAmount(String purchaseAmountInput) {
        validateNull(purchaseAmountInput);

        int purchaseAmount = parseInteger(purchaseAmountInput);

        validatePurchaseAmount(purchaseAmount);

        return purchaseAmount / LOTTO_PRICE;
    }

    public List<Integer> handleWinningNumbers(String winningNumbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numbersInput = winningNumbersInput.split(COMMA);
        for (String numberInput : numbersInput) {
            validateNull(numberInput);

            int winningBall = parseInteger(numberInput);
            validateBall(winningBall);
            winningNumbers.add(winningBall);
        }
        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public int handleBonusBall(String bonusBallInput, List<Integer> winningNumber) {
        validateNull(bonusBallInput);

        int bonusBall = parseInteger(bonusBallInput);

        validateBonusBall(bonusBall, winningNumber);

        return bonusBall;
    }

    private void validateNull(String input) {
        if (input == null || input.isBlank()) {
            throw new NullInputException();
        }
    }

    private int parseInteger(String input) {
        String trimmedInput = input.trim();

        try {
            return Integer.parseInt(trimmedInput);
        } catch (Exception e) {
            throw new ParseException();
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new InvalidPurchaseAmountException();
        }
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }

    private void validateBall(int ball) {
        if (ball < MIN_RANGE || ball > MAX_RANGE) {
            throw new InvalidBallException();
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>(winningNumbers);
        if (uniqueWinningNumbers.size() != LOTTO_SIZE) {
            throw new InvalidWinningNumbersException();
        }
    }

    private void validateBonusBall(int bonusBall, List<Integer> winningNumber) {
        validateBall(bonusBall);

        if (winningNumber.contains(bonusBall)) {
            throw new InvalidBonusBallException();
        }
    }
}
