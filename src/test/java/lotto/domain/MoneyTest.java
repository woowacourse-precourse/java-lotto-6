package lotto.domain;

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
}
