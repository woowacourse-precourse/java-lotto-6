package lotto;

import lotto.validator.InputBonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputBonusNumberValidatorTest {

    InputBonusNumberValidator inputBonusNumberValidator = new InputBonusNumberValidator();

    @Test
    @DisplayName("로또 보너스 번호 입력 안함 테스트")
    void 로또_보너스_번호_입력_안함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputBonusNumberValidator.validateNonInputBonusNumber(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 보너스 번호 숫자 아닌 경우 테스트")
    void 로또_보너스_번호_숫자_아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputBonusNumberValidator.validateNonIntegerBonusNumber("a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 보너스 번호 1개가 아닌 경우 테스트")
    void 로또_보너스_번호_1개_아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputBonusNumberValidator.validateNonNumberSizeOne("5,23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 보너스 번호 1~45 사이 아닌 경우 테스트")
    void 로또_보너스_번호_범위_이탈() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputBonusNumberValidator.validateWrongRangeBonusNumber("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("로또 보너스 번호 1~45 사이 아닌 경우 테스트2")
    void 로또_보너스_번호_범위_이탈2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputBonusNumberValidator.validateWrongRangeBonusNumber("46"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
