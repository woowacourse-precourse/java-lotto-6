package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.lottoseller.InsufficientMoneyException;
import lotto.exception.lottoseller.NonMultipleMoneyException;
import lotto.helper.FixedNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoSellerTest {
    FixedNumberGenerator fixedNumberGenerator;
    LottoPublisher lottoPublisher;
    LottoSeller lottoSeller;

    @BeforeEach
    void setUp() {
        fixedNumberGenerator = new FixedNumberGenerator();
        lottoPublisher = new LottoPublisher(fixedNumberGenerator);
        lottoSeller = new LottoSeller(lottoPublisher);
    }

    @DisplayName("로또 판매 테스트")
    @Nested
    class LottoSellerSellTest {

        @DisplayName("지불한 금액이 로또 가격보다 작으면 예외가 발생한다.")
        @Test
        void sellLottoByMoneyUnderLottoPrice() {
            Money money = new Money(LottoSeller.LOTTO_PRICE - 1);

            assertThatThrownBy(() -> lottoSeller.sell(money))
                    .isInstanceOf(InsufficientMoneyException.class);
        }

        @DisplayName("지불한 금액이 로또 가격의 배수가 아니면 예외가 발생한다.")
        @Test
        void sellLottoByMoneyNotMultipleOfLottoPrice() {
            Money money = new Money(LottoSeller.LOTTO_PRICE + 1);

            assertThatThrownBy(() -> lottoSeller.sell(money))
                    .isInstanceOf(NonMultipleMoneyException.class);
        }
    }
}
