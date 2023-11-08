package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.util.ConvertInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ConvertInputTest {
    @DisplayName("구입 금액을 두 개 이상 입력하면 예외가 발생한다.")
    @Test
    void manyPurchaseAmountTest() {
        assertThatThrownBy(() -> ConvertInput.makePlayerMoneyToInt("1000,2000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    void AmountNumberIsNotNumberTest() {
        assertThatThrownBy(() -> ConvertInput.makePlayerMoneyToInt("1e"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 수를 입력하면 예외 발생 없이 변환한다.")
    @CsvSource({"1000,1000", "3000,3000", "450,450"})
    @ParameterizedTest
    void validIntegerAmountNumberTest(String input, int expected) {
        assertThat(ConvertInput.makePlayerMoneyToInt(input)).isEqualTo(expected);
    }

    @DisplayName("로또 번호에 수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    void LottoNumberHasNotNumberTest() {
        assertThatThrownBy(() -> ConvertInput.makeLottoNumberToList("1,w,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("입력한 문자열이 정수로만 이루어져 있다면 리스트로 변환한다.")
    @MethodSource("generateLottoData")
    void validIntegerLottoNumbersTest(String input, List<Integer> expected) {
        assertThat(ConvertInput.makeLottoNumberToList(input)).isEqualTo(expected);
    }

    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6,7", List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of("1,45,2,9,0", List.of(1, 45, 2, 9, 0)),
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6))
        );
    }

    @DisplayName("보너스 번호을 두 개 이상 입력하면 예외가 발생한다.")
    @Test
    void manyBonusNumberTest() {
        assertThatThrownBy(() -> ConvertInput.makeBonusNumberToInt("1,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 수가 아닌 값이 포함되면 예외가 발생한다.")
    @Test
    void BonusNumberIsNotNumberTest() {
        assertThatThrownBy(() -> ConvertInput.makeBonusNumberToInt("1e"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 수가 정수형일 때는 정수로 반환한다.")
    @CsvSource({"1,1", "10,10", "46,46"})
    @ParameterizedTest
    void validIntegerBonusNumberTest(String input, int expected) {
        assertThat(ConvertInput.makeBonusNumberToInt(input)).isEqualTo(expected);
    }
}
