package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

    @Test
    @DisplayName("당첨 번호 문자열을 정수 리스트로 변환하는 기능 테스트")
    void convertLottoNumbersTest() {
        //given
        String input = "1,2,3,4,5,6";
        //when
        List<Integer> result = Converter.convertWinningNumbers(input);
        //then
        assertThat(result.size()).isEqualTo(6);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호에 숫자가 아닌 문자가 포함된 경우 예외 처리 테스트")
    void letterLottoNumbersInputTest() {
        //given
        String input = "1,2,3,4,5,a";
        //then
        assertThatThrownBy(() -> Converter.convertWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 문자열을 정수로 변환하는 기능 테스트")
    void convertBonusNumberTest() {
        //given
        String input = "45";
        //when
        int bonus = 45;
        int result = Converter.convertBonusNumber(List.of(1,2,3,4,5,6), input);
        //then
        assertThat(result).isEqualTo(bonus);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 문자로 주어진 경우 예외 처리 테스트")
    void letterBonusNumberInputTest() {
        //given
        String input = "a";
        //then
        assertThatThrownBy(() -> Converter.convertBonusNumber(List.of(1,2,3,4,5,6), input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}