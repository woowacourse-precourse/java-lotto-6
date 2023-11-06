package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @DisplayName("금액은 로또개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000 :1", "12000 :12", "2000 :2", "230000 : 230"}, delimiter = ':')
    void toLottoCount(int value, int expected) {
        Money money = Money.from(value);
        assertThat(money.getLottoCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("금액이 1000원 보다 작을시 에러를 발생시킨다.")
    @ValueSource(longs = {-1000, -1, 0})
    void moneyThrowsErrorWhenLessThanMin(long input) {
        assertThatThrownBy(() -> Money.from(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액의 최소단위는 1000원 이상이어야 합니다. %s ", input);
    }

    @ParameterizedTest
    @DisplayName(" 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.")
    @ValueSource(longs = {1234, 1001, 2001, 3001})
    void validateAmountIsMultipleOfThousand(long input) {
        assertThatThrownBy(() -> Money.from(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000원으로 나누어 떨어지지 않는 금액입니다. %s", input);
    }
}
