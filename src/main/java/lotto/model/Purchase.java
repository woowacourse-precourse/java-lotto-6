package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

public class Purchase {

    public static final int ZERO = 0;

    private final int purchaseMoney;
    private final int lottoAmount;

    public Purchase(int purchaseMoney) {
        validate(purchaseMoney);

        this.purchaseMoney = purchaseMoney;
        this.lottoAmount = purchaseMoney / LottoConstant.LOTTO_PRICE.get();
    }

    private void validate(int purchaseMoney) {
        validateBiggerThanZero(purchaseMoney);
        validateMultipleOf1000(purchaseMoney);
    }

    private void validateBiggerThanZero(int purchaseMoney) {
        if (purchaseMoney <= ZERO) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MONEY_NOT_BIGGER_THAN_ZERO.get());
        }
    }

    private void validateMultipleOf1000(int purchaseMoney) {
        if (purchaseMoney % LottoConstant.LOTTO_PRICE.get() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MONEY_NOT_MULTIPLE_OF_1000.get());
        }
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}