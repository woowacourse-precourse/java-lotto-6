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

}
