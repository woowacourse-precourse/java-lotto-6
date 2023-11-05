package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.function.Function;

public class AmountInputView<T> implements InputView<T> {
    private final Function<String, T> stringToConverter;

    public AmountInputView(Function<String, T> stringToConverter) {
        this.stringToConverter = stringToConverter;
    }

    @Override
    public T getInput() {
        String amountString;
        do {
            amountString = inputAmount();
        } while (isAmountFormValidator(amountString));
        return convertInputValue(amountString);
    }

    public T convertInputValue(String inputValue) {
        return stringToConverter.apply(inputValue);
    }

    public String inputAmount() {
        System.out.println(InputViewConstants.INPUT_AMOUNT.getInputMessage());
        return readLine();
    }

    public void validateNumeric(String amountString) {
        if (amountString.matches(InputViewConstants.INPUT_AMOUNT_REGEX.getInputMessage())) {
            return;
        }
        throw new IllegalArgumentException(InputViewConstants.INPUT_NUMERIC_ERROR.getInputMessage());
    }

    public void validateUnitThousand(String inputAmount) {
        if (Integer.parseInt(inputAmount) % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException(InputViewConstants.INPUT_UNIT_ERROR.getInputMessage());
    }

    public boolean isAmountFormValidator(String inputAmount) {
        try {
            validateNumeric(inputAmount);
            validateUnitThousand(inputAmount);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
