package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("입력받은 구입 금액이 1,000의 배수가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByNotDuplicateOfThousand() {
        int inputMoney = 1400;
        assertThatThrownBy(() -> new Money(inputMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 구입 금액 / 1,000이 로또의 개수가 된다.")
    @Test
    void getLottoCount() {
        int inputMoney = 3000;
        Money money = new Money(inputMoney);
        int result = money.getLottoCount();

        assertThat(result).isEqualTo(3);
    }
}