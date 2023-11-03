package lotto.service;

import lotto.validator.InputValidator;
import lotto.view.InputView;

public class LottoService {
    private final static int LOTTO_PRICE = 1000;
    private final InputValidator inputValidator;

    public LottoService(InputView inputView, InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int getTotalPurchaseNumber(int totalMoney) {
        inputValidator.validateMoney(totalMoney);
        return totalMoney / LOTTO_PRICE;
    }
}
