package lotto.domain;

import lotto.utils.LottoValidator;

public class LottoPurchase {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public LottoPurchase(String moneyInput) {
        this.money = validate(moneyInput);
    }

    public int getMoney() {
        return money;
    }

    public int calculateLottoCount() {
        return money / LOTTO_PRICE;
    }

    private int validate(String moneyInput) {
        LottoValidator lottoValidator = new LottoValidator();
        int money = lottoValidator.validateNonNumeric(moneyInput);
        lottoValidator.validatePurchaseAmount(money);
        return money;
    }

}
