package lotto.model;

import static lotto.view.InputView.ERROR_MESSAGE;

public class Money {
    public static final int MONEY_UNIT = 1000;

    private final int inputMoney;

    public Money(int inputMoney){
        validMoney(inputMoney);
        this.inputMoney = inputMoney;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    private void validMoney(int inputMoney){
        if(inputMoney % MONEY_UNIT != 0){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
