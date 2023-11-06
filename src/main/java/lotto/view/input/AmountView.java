package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.function.Function;

public class AmountView<T> implements Input<T> {
    private final Function<String, T> stringToConverter;

    public AmountView(Function<String, T> stringToConverter) {
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
        System.out.println(InputConstants.INPUT_AMOUNT.getInputMessage());
        return readLine();
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

    public void validateNumeric(String amountString) {
        if (amountString.matches(InputConstants.INPUT_AMOUNT_REGEX.getInputMessage())) {
            return;
        }
        throw new IllegalArgumentException(InputConstants.INPUT_NUMERIC_ERROR.getInputMessage());
    }

    public void validateUnitThousand(String inputAmount) {
        if (Integer.parseInt(inputAmount) % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException(InputConstants.INPUT_UNIT_ERROR.getInputMessage());
    }

}
