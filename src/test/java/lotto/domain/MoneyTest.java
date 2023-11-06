package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, -15000, -10})
    @DisplayName("로또 구입 금액이 양수가 아니라면 예외 발생")
    void moneyNotPositiveExceptionTest(final int amount) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> Money.from(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1001, 1010, 1011, 1100, 1101, 1111})
    @DisplayName("로또 구입 금액이 1,000원 단위가 아니라면 예외 발생")
    void moneyNotMathScaleExceptionTest(final int amount) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> Money.from(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 15000, 3000})
    @DisplayName("로또 구입 금액이 양수이고 1,000원 단위라면 정상 생성")
    void moneyCreateTest(final int amount) {
        // expected
        assertDoesNotThrow(() -> Money.from(amount));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "3000,3", "15000,15"})
    @DisplayName("로또 구입 금액으로 로또 구매 갯수를 반환한다.")
    void moneyCreateTest(final int amount, final int expected) {
        // given
        Money money = Money.from(amount);

        // when
        int actual = money.calculateLottoPurchaseCount();

        // then
        assertEquals(expected, actual);
    }
}