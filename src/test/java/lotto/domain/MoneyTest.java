package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @DisplayName("입력 값이 1000으로 나누어지는 값인지 확인한다")
    @Test
    void checkMultipleOfThousand() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 한장이 1000원이므로 구매금액은 1000원 단위로 입력해야 합니다.");
    }

    @DisplayName("돈을 1000으로 나누어 전달한다")
    @Test
    void createCountOfLotto() {
        assertThat(new Money(20000).calculatePurchasedLotto()).isEqualTo(20);
    }

    @DisplayName("로또 구매 개수로 변환하여 문자열로 전달한다")
    @Test
    void createStringCountOfLotto() {
        assertThat(new Money(20000).toString()).isInstanceOf(String.class);
    }
}
