package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.exception.Message.CANNOT_BUY_LOTTO_EXCEPTION;
import static lotto.exception.Message.MONEY_CREATION_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @DisplayName("로또를 몇 개 살 수 있는지 알려준다.")
    @ValueSource(longs = {1000, 2000, 7000})
    void money_to_lotto_cnt(long fee) {
        // given
        Money money = new Money(fee);

        // when
        long lottoCnt = money.toLottoCnt();

        // then
        assertThat(lottoCnt).isEqualTo(fee / LOTTO_PRICE);
    }

    @ParameterizedTest
    @DisplayName("돈이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ValueSource(longs = {1001, 2100, 7030})
    void money_to_lotto_cnt_error(long fee) {
        // given
        Money money = new Money(fee);

        // when // then
        assertThatThrownBy(money::toLottoCnt)
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(CANNOT_BUY_LOTTO_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("돈이 0원 미만이라면 예외가 발생한다.")
    @ValueSource(longs = {-1, -1000, -30})
    void money_is_less_than_zero(long fee) {

        // when // then
        assertThatThrownBy(() -> new Money(fee))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(MONEY_CREATION_EXCEPTION);
    }
}
