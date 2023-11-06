package lotto.service;

import lotto.model.LottoCondition;
public class PaymentService {
    private final int lottoPrice = LottoCondition.LOTTO_PRICE.getNumber();

    public int getLottoCount(int totalPrice) {
        return totalPrice / lottoPrice;
    }
}
