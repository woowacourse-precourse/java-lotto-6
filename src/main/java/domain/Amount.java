package domain;

import lotto.view.Output;

public class Amount {

    private static final String ERROR_MESSAGE_NOT_DIVIDED = "로또 금액으로 나누어 떨어지는 금액이어야 합니다.";
    private int amount;

    public Amount(Integer amount) {
        validateDividedByLottoPrice(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }


    private void validateDividedByLottoPrice(Integer amount) {
        if (amount % Lotto.PRICE != 0) {
            Output.printErrorMessage(ERROR_MESSAGE_NOT_DIVIDED);
            throw new IllegalArgumentException();
        }
    }
}
