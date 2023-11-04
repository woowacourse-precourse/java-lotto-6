package lotto.service;

import lotto.model.PurchaseAmount;

public class LottoService {
    private static final String NON_NUMERIC_INPUT_MESSAGE = "[ERROR] 숫자를 입력해주세요";
    private PurchaseAmount purchaseAmount;

    public void initPurchaseAmount(String inputMoney) {
        this.purchaseAmount = new PurchaseAmount(inputMoney);
    }

}
