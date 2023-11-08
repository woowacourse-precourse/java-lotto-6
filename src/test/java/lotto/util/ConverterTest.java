package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}