package lotto.domain;

import static lotto.domain.LottoConstants.MAX_NUMBER;
import static lotto.domain.LottoConstants.MIN_NUMBER;
import static lotto.domain.LottoConstants.NUMBER_COUNT;
import static lotto.error.ExceptionCode.EXCEED_BUY_COUNT;
import static lotto.error.ExceptionCode.INVALID_BUY_COUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import java.util.List;
import lotto.error.LottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

public class LottoSellerTest {

    private final NumberGenerator generator = BDDMockito.mock(NumberGenerator.class);

    private final LottoSeller lottoSeller = new LottoSeller(generator);

    @DisplayName("주문한 금액만큼 로또를 구매한다.")
    @Test
    void buyLotto() {
        // given
        given(generator.generate(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)).willReturn(List.of(1, 2, 3, 4, 5, 6));
        final Money moneyForBuy = new Money(5000L);

        // when
        final Lottos lottos = lottoSeller.buy(moneyForBuy);

        // then
        assertAll(() -> {
            then(generator).should(times(5)).generate(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
            assertThat(lottos.getLottoCount()).isEqualTo(5);
        });
    }

    @DisplayName("주문한 금액이 100,000원을 넘기면 예외가 발생한다.")
    @Test
    void buyLottoWithOverMoney() {
        // given
        final Money moneyForBuy = new Money(110000L);

        // when & then
        assertThatThrownBy(() -> lottoSeller.buy(moneyForBuy))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(EXCEED_BUY_COUNT.getMessage());
    }
    
    @DisplayName("주문한 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void buyLottoWithNotThousandUnit() {
        // given
        final Money moneyForBuy = new Money(1001L);

        // when & then
        assertThatThrownBy(() -> lottoSeller.buy(moneyForBuy))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_BUY_COUNT_UNIT.getMessage());
    }
}
