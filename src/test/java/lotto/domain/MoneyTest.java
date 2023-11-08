package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.NonNumberException;
import lotto.exception.money.MinimumMoneyException;
import lotto.exception.money.MoneyOutOfRangeException;
import lotto.exception.money.MoneyUnitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("금액은 숫자만 가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "천원", "1000won"})
    void isNumeric(String moneys) {
        assertThatThrownBy(() -> Money.of(moneys))
                .isInstanceOf(NonNumberException.class)
                .hasMessage("숫자만 입력해 주세요.");
    }

    @DisplayName("최소 금액은 1,000원 이상 이여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "0", "500"})
    void isOverThousand(String moneys) {
        assertThatThrownBy(() -> Money.of(moneys))
                .isInstanceOf(MinimumMoneyException.class)
                .hasMessage("최소 금액은 1,000원 입니다.");
    }

    @DisplayName("금액은 1,000원 단위여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1200", "1350", "1557"})
    void isDivisibleByThousand(String moneys) {
        assertThatThrownBy(() -> Money.of(moneys))
                .isInstanceOf(MoneyUnitException.class)
                .hasMessage("금액은 1,000원 단위로 입력해 주세요.");
    }

    @DisplayName("최대 구매 금액은 2,147,483,000원 이다.")
    @Test
    void isMaxPrice() {
        assertThatThrownBy(() -> Money.of("2147484000"))
                .isInstanceOf(MoneyOutOfRangeException.class)
                .hasMessage("최대 2,147,483,000원 까지 구매 가능합니다.");
    }

    @DisplayName("총 구매 갯수는 (총 구매 금액 / 로또 가격) 이다.")
    @Test
    void calculateQuantity() {
        Money money = Money.of("220000");
        int lottoPrice = 2000;
        int quantity = money.calculateLottoQuantity(lottoPrice);

        assertThat(quantity).isEqualTo(110);
    }

    @DisplayName("총 당첨 상금이 주어 졌을 때 수익률은 (총 당첨금액 / 총 구매 금액) * 100 이다")
    @Test
    void calculateProfitRate() {
        Money money = Money.of("10000");
        long prize = 2700000L;
        float profitRate = money.calculateLottoProfitRate(prize);

        assertThat(profitRate).isEqualTo(27000);
    }

}