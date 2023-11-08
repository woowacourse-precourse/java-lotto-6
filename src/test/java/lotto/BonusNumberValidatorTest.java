package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validator.BonusNumberValidator;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {
    private static final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();

    @Test
    void 보너스_정상_테스트() {
        assertThatCode(() -> bonusNumberValidator.validate("43"))
                .doesNotThrowAnyException();
    }

    @Test
    void 보너스_문자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> bonusNumberValidator.validate("1a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 보너스_범위_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> bonusNumberValidator.validate("46"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
