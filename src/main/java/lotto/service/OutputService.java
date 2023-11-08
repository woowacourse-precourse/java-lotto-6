package lotto.service;

import static lotto.view.InputView.inputMoney;

public class OutputService {
    private static final int LOTTO_PRICE = 1000;
    public static int quantity;

    public static int calculateLottoQuantity() {
        quantity = inputMoney / LOTTO_PRICE;

        return quantity;
    }
}
