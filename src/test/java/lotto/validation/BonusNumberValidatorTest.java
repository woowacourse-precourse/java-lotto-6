package lotto.validation;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.exception.NumberDuplicateException;
import lotto.exception.NumberRangeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberValidatorTest {

    private Lotto winningLotto;

    @BeforeEach
    void initTest() {
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @DisplayName("보너스번호 정상입력 테스트")
    @CsvSource({"'1'", "'2'", "'3'"})
    void validateBonusReadLineTest(String readLine) {
        Assertions.assertThatCode(() ->
                        BonusNumberValidator.validateBonusReadLine(readLine))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("보너스번호 정상형식 테스트")
    @CsvSource({"43", "44", "45"})
    void validateBonusNumber(int bonus) {
        Assertions.assertThatCode(() ->
                        BonusNumberValidator.validateBonusNumber(bonus, winningLotto))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("[ERROR] 당첨번호와 중복값이 있을때")
    @CsvSource({"1", "2", "3"})
    void checkDuplicateTest(int bonus) {
        Assertions.assertThatThrownBy(() ->
                        BonusNumberValidator.validateBonusNumber(bonus, winningLotto))
                .isInstanceOf(NumberDuplicateException.class);
    }

    @ParameterizedTest
    @DisplayName("[ERROR] 보너스번호가 1~45사이가 아닐때")
    @CsvSource({"46", "-1", "128", "-128"})
    void checkRangeTest(int bonus) {
        Assertions.assertThatThrownBy(() ->
                        BonusNumberValidator.validateBonusNumber(bonus, winningLotto))
                .isInstanceOf(NumberRangeException.class);
    }
}