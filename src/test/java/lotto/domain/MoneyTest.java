package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @DisplayName("구입 금액이 양수가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByNegativeNumber() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 구입 가능한 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyDivisibleByUnit() {
        assertThatThrownBy(() -> new Money(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액을 구입 단위로 나누어 살 수 있는 로또의 개수를 알 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1000, 1", "5000, 1000, 5", "6000, 2000, 3"})
    void getLottoTicketCount(long amount, int unit, int count) {
        assertThat(new Money(amount).getLottoTicketCount(unit)).isEqualTo(count);
    }

}
