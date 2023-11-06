package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BuyingCostTest {
    private final BuyingCost sample = new BuyingCost();

    @ParameterizedTest
    @DisplayName("입력된 로또 구입 금액이 유효하면 정수로 변환된 값을 반환")
    @CsvSource(value = {"'1000', 1000", "'1000000', 1000000", "'1000000000', 1000000000"})
    void getCost_test(String input, int expected) {
        assertThat(sample.getCost(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("입력된 로또 구입 금액을 정수로 변환 가능하지 않으면 에러 메시지 출력")
    @ValueSource(strings = {"1000k", "1,000", "1_000"})
    void validate_integerTest(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.validate(input));
        assertThat(exception.getMessage()).contains("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("입력된 로또 구입 금액이 양수가 아니면 에러 메시지 출력")
    @ValueSource(strings = {"-1000", "0"})
    void validate_positiveTest(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.validate(input));
        assertThat(exception.getMessage()).contains("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("입력된 로또 구입 금액이 1000원으로 나누어떨어지지 않으면 에러 메시지 출력")
    @ValueSource(strings = {"1234", "1230", "1200"})
    void validate_DividableTest(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> sample.validate(input));
        assertThat(exception.getMessage()).contains("[ERROR]");
    }
}