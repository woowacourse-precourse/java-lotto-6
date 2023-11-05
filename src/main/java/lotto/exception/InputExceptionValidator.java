package lotto.exception;

import java.util.List;

public class InputExceptionValidator {
    protected InputExceptionValidator() {
    }

    public Exception inputPurchaseAmountValidation(String userInput) {
        try {
            numberFormatValidation(userInput);
            nagativeValidation(Integer.valueOf(userInput));
            dividedValidation(Integer.valueOf(userInput));
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return e;
        }

        return null;
    }

    public Exception inputWinningNumbersValidation(List<String> splitedList) {
        try {
            splitedList.forEach(this::numberFormatValidation);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return e;
        }

        return null;
    }

    private void numberFormatValidation(String userInput) throws InputException {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new InputException(ExceptionCode.INVALID_INPUT_INTEGER);
        }
    }

    private void nagativeValidation(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new InputException(ExceptionCode.INVALID_INPUT_INTEGER);
        }
    }

    private void dividedValidation(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new InputException(ExceptionCode.INVALID_INPUT_DIVIDED);
        }
    }
}