package lotto.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoInputValidatorTest {

    WinningNumberInputValidator winningNumberInputValidator = new WinningNumberInputValidator();

    @ParameterizedTest
    @CsvSource(value = {"'1,2,3,4,5,6', true", "'1,2,3,4,5', false"})
    @DisplayName("쉼표 5개 여부 테스트")
    void 쉼표_5개_여부_테스트(String winningNumber, boolean expected) {
        assertThat(winningNumberInputValidator.isCommaFive(winningNumber)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "45, true", "20, true", "0, false", "46, false"})
    @DisplayName("당첨 번호 범위 테스트")
    void 당첨_번호_범위_테스트(int oneWinningNumber, boolean expected) {
        assertThat(winningNumberInputValidator.isLottoNumber(oneWinningNumber)).isEqualTo(expected);
    }

    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, true),
                Arguments.of(Arrays.asList(8, 2, 3, 4, 15, 28), 8, false)
        );
    }

    @ParameterizedTest
    @MethodSource("generateLottoData")
    @DisplayName("당첨 번호 중복 테스트")
    void 당첨_번호_중복_테스트(List<Integer> numbers, int bonusNumber, boolean expected) {
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        assertThat(winningNumberInputValidator.isWinningLottoNotDuplication(winningLotto)).isEqualTo(expected);
    }
}