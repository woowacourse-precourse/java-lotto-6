package lotto.validation;

import lotto.util.message.ErrorMessage;

public class InputValidator {

    private static final int MINIMUM_PRICE = 1000;
    private static final String DELIMITER = ",";
    private static final int LOTTO_RANGE_START = 1;
    private static final int LOTTO_RANGE_END = 45;

    public boolean validateInputPrice(String inputPrice) {
        int price;
        try {
            price = checkPriceNumber(inputPrice);
            checkMinPrice(price);
            checkPrice(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private int checkPriceNumber(String userInput) {
        int userInputNumber;

        try {
            userInputNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                ErrorMessage.REQUEST_MORE_THAN_MINIMUM_PRICE.getErrorMessage());
        }

        return userInputNumber;
    }

    private int checkNumber(String userInput) {
        int userInputNumber;

        try {
            userInputNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.REQUEST_NUMBER_RANGE.getErrorMessage());
        }

        return userInputNumber;
    }

    private void checkMinPrice(int price) {
        if (price >= MINIMUM_PRICE) {
            return;
        }
        throw new IllegalArgumentException(
            ErrorMessage.REQUEST_MORE_THAN_MINIMUM_PRICE.getErrorMessage());

    }

    private void checkPrice(int price) {
        if (price % MINIMUM_PRICE != 0) {
            throw new IllegalArgumentException(
                ErrorMessage.REQUEST_PRICE_STANDARD.getErrorMessage());
        }
    }

    public boolean validateInputBonusNumber(String inputBonusNumber) {
        int bonusNumber;
        try {
            bonusNumber = checkNumber(inputBonusNumber);
            checkNumberRange(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    private void checkNumberRange(int bonusNumber) {
        if (bonusNumber >= LOTTO_RANGE_START && bonusNumber <= LOTTO_RANGE_END) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.REQUEST_NUMBER_RANGE.getErrorMessage());
    }

    public boolean validateInputWinnerLotto(String input) {
        try {
            checkSplit(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private void checkSplit(String userInput) {
        if (!userInput.contains(DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.REQUEST_DELIMITER.getErrorMessage());
        }
    }
}
