package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("현금")
class CashTest {
    @DisplayName("1000원 보다 작은 금액 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(ints = {100, 200, 300, 400, 500})
    void createCashSmallerUnitExceptionTest(int amount) {
        assertThrows(IllegalArgumentException.class,
                () -> new Cash(amount)
        );
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 금액 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(ints = {1001, 2002, 3003, 4004, 5005})
    void createCashNotAvailableAmount(int amount) {
        assertThrows(IllegalArgumentException.class,
                () -> new Cash(amount)
        );
    }

    @DisplayName("생성 성공 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void createCashSuccessTest(int amount) {
        assertDoesNotThrow(() -> new Cash(amount));
    }


    @DisplayName("지불 기능 성공 테스트")
    @ParameterizedTest
    @MethodSource("cashDummy")
    void spendSuccessTest(List<Cash> cashDummy) {
        List<Cash> cashes = cashDummy;

        boolean result = cashes.stream()
                .allMatch(cash -> cash.spendOneUnit() == true);

        assertThat(result).isTrue();

    }


    @DisplayName("지불 기능 실패 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void spendNotSuccessTest(int amount) {
        final Cash cash = new Cash(amount);


        while (cash.isAfford()) {
            cash.spendOneUnit();
        }
        Boolean isSpend = cash.spendOneUnit();

        assertEquals(false, isSpend);
    }

    static Stream<Arguments> cashDummy() {
        return Stream.of(
                Arguments.arguments(List.of(
                        new Cash(1000),
                        new Cash(2000),
                        new Cash(3000),
                        new Cash(4000),
                        new Cash(5000))
                )
        );
    }
}