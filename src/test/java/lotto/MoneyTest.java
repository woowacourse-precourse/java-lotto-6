package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("로또를 사는 금액의 입력이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoBuyMoneyByBlankInput() {
        assertThatThrownBy(() -> new Money(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 사는 금액의 입력이 1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoBuyMoneyNotThousandUnit() {
        assertThatThrownBy(() -> new Money("5500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 사는 금액의 입력이 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoBuyMoneyNotInteger() {
        assertThatThrownBy(() -> new Money("NotNumber"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 사는 금액의 최대 금액은 10만원 이상이 될 경우 예외가 발생한다.")
    @Test
    void createLottoBuyMoneyOverTenThousand() {
        assertThatThrownBy(() -> new Money("200000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
