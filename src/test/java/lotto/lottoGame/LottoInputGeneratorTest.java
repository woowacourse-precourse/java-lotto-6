package lotto.lottoGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoInputGeneratorTest {
    LottoInputGenerator lottoInputGenerator;

    @BeforeEach
    void setup() {
        lottoInputGenerator = new LottoInputGenerator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,,5", "a,b,c,d,e,f", "1, 2,3,4,5,6", "01,02,03,04,05,06"})
    @DisplayName("입력된 문자가 잘못된 형식이면 에러가 발생한다.")
    void 입력문자_잘못된형식_에러발생(String inputNumbers) {
        assertThatThrownBy(() -> lottoInputGenerator.inputNumbersToLotto(inputNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "10", "11111"})
    @DisplayName("자연수면 정상작동한다.")
    void 보너스값_인트변환(String bonusNumber) {
        assertThat(lottoInputGenerator.inputBonusToValidatedValue(bonusNumber))
            .isEqualTo(Integer.parseInt(bonusNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "0", "11111."})
    @DisplayName("자연수가 아니면 에러가 발생한다.")
    void 보너스값_인트변환_자연수가아닌값(String bonusNumber) {
        Assertions.assertThatThrownBy(() -> lottoInputGenerator.inputBonusToValidatedValue(bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }
}