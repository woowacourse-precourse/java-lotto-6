package lotto.service;

import static lotto.config.LottoPrice.LOTTO_PRICE;

import lotto.config.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentTest {
    Payment payment;

    @BeforeEach
    void beforeEach() {
        payment = new AppConfig().payment();
    }

    @Test
    void 로또구매테스트() {
        //given
        int money = 10000;
        int lottoPrice = LOTTO_PRICE.getPrice();
        //when
        int testResult = payment.pay(money, lottoPrice);
        //then
        Assertions.assertThat(testResult).isEqualTo(money/lottoPrice);
    }
}