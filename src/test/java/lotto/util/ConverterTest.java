package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {
    @Test
    @DisplayName("구매 금액 문자열을 정수로 변환하는 기능 테스트")
    void convertPurchaseAmountTest() {
        //given
        String input = "15000";
        //when
        int amount = 15000;
        int result = Converter.convertPurchaseAmount(input);
        //then
        assertThat(result).isEqualTo(amount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000a", "1 000", "####"})
    @DisplayName("숫자가 아닌 문자가 포함된 구매 금액 문자열들을 예외 처리하는 테스트")
    void convertPurchaseAmountExceptionTest(String input) {
        //then
        assertThatThrownBy(() -> Converter.convertPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}