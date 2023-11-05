package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
            sizeValidation(splitedList);
            duplicatedValidation(splitedList);
            splitedList.forEach(this::numberFormatValidation);
            splitedList.stream()
                    .map(Integer::valueOf)
                    .forEach(this::rangeValidation);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return e;
        }

        return null;
    }

    public Exception inputBonusNumberValidation(String userInput) {
        try {
            numberFormatValidation(userInput);
            rangeValidation(Integer.valueOf(userInput));
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

    private void sizeValidation(List<String> splitedList) {
        if (splitedList.size() != 6) {
            throw new InputException(ExceptionCode.INVALID_INPUT_SIZE);
        }
    }

    private void duplicatedValidation(List<String> splitedList) {
        Set<String> uniqueElements = new HashSet<>();
        Optional<String> duplicatedElement = splitedList.stream()
                .filter(e -> !uniqueElements.add(e))
                .findFirst();

        if (duplicatedElement.isPresent()) {
            throw new InputException(ExceptionCode.INVALID_INPUT_DUPLICATED);
        }
    }

    private void rangeValidation(int number) {
        if (!(1 <= number && number <= 45)) {
            throw new InputException(ExceptionCode.INVALID_INPUT_RANGE);
        }
    }
}