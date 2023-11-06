package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    public void 금액_객체생성_정상문자값() {
        // Given
        String input = "5000";

        // When
        Money money = Money.create(input);

        // Then
        assertTrue(money.isSameAmount(5000));
    }

    @Test
    public void 금액_객체생성_정상정수값() {
        // Given
        int input = 5000;

        // When
        Money money = Money.create(input);

        // Then
        assertTrue(money.isSameAmount(5000));
    }

    @Test
    public void 금액_앞뒤의_공백제거() {
        // Given
        String input = " 1000 ";

        // When
        Money money = Money.create(input);

        // Then
        assertTrue(money.isSameAmount(1000));
    }

    @Test
    public void 금액_정수가아닌_문자일시_예외발생() {
        // Given
        String input = "k";

        // When && Then
        assertThatThrownBy(() -> Money.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }

    @Test
    public void 금액_정수범위_벗어난_숫자일시_예외발생() {
        // Given
        String input = "2200000000";

        // When && Then
        assertThatThrownBy(() -> Money.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }

}
