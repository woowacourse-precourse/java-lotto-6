package lotto.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {
    @ParameterizedTest
    @CsvSource({
            "1234",
            "100",
            "0"
    })
    @DisplayName("로또 구입 금액 검증 실패 테스트")
    void validateDivideMoneyTest(int money) {
        assertThrows(IllegalArgumentException.class,
                () -> new Money(money));
    }
}
