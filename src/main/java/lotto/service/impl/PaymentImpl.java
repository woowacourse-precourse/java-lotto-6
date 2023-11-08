package lotto.service.impl;

import lotto.service.Payment;

public class PaymentImpl implements Payment {
    @Override
    public int pay(int money, int lottoPrice) {
        return money / lottoPrice;
    }
}
