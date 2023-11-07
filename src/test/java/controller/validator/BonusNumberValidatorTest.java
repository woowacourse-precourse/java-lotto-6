package controller.validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

class BonusNumberValidatorTest extends NsTest {
    private final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    @DisplayName("숫자가 아닌 문자가 포함되면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"12a","a13"," 1 3"})
    void checkBonusNumberFormat(String input) {
        assertThatThrownBy(() -> bonusNumberValidator.checkBonusNumberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.LOTTO_MUST_BE_COMPOSED_OF_NUMBER.getErrorMessage());
    }

    @DisplayName("로또 번호의 범위를 넣어가는 숫자 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings ={"-12","0","46","100"})
    void checkBonusNumberRange(String input) {
        assertThatThrownBy(() -> bonusNumberValidator.checkBonusNumberValidation(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).isEqualTo(ErrorMessage.OUT_OF_LOTTO_NUMBER_RANGE.getErrorMessage());
    }

    @Override
    public void runMain(){

    }
}