package lotto.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningNumberValidationTest {

    private final LottoValidation lottoValidation = new WinningNumberValidation();

    @DisplayName("입력한 번호의 개수가 6개가 아니면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "12"})
    void winningNumberValidationTest(String value) {
        // when
        boolean result = lottoValidation.validate(value);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("입력한 값 중 숫자가 아닌 값이 포함되어 있으면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,가,4,5", "가,나,다,6,7", "12라", "1,2,,3,4"})
    void winningNumberValidationTest2(String value) {
        // when
        boolean result = lottoValidation.validate(value);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("입력한 번호가 1~45 사이가 아닌 값이 포함되어 있으면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,-1", "1,2,3,4,5,46", "1,2,3,4,5,55"})
    void winningNumberValidationTest3(String value) {
        // when
        boolean result = lottoValidation.validate(value);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("입력한 번호들 중 중복되는 번호가 포함되어 있으면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,1,1,1,1,1"})
    void winningNumberValidationTest4(String value) {
        // when
        boolean result = lottoValidation.validate(value);
        // then
        assertThat(result).isFalse();
    }
}