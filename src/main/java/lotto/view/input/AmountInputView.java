package lotto.view.input;

import lotto.exception.Exceptions;
import lotto.view.Prompt;

public class AmountInputView extends InputView {
    private int inputAmount;

    @Override
    protected void Validation(String inputMessage) {
        Exceptions.checkIsNumber(inputMessage);
        inputAmount = Integer.parseInt(inputMessage);

        Exceptions.checkIsThousandUnit(inputAmount);
        Exceptions.checkIsNationalNumber(inputAmount);
    }

    public int getNumberOfLotto() {
        getInput(Prompt.TOTAL_BUYING_AMOUNT);
        return inputAmount / 1000;
    }
}
