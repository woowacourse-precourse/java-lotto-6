package lotto.domain.validate;

import lotto.domain.validate.exception.InputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BonusNumberValidateTest {
    InputValidator inputValidator;
    List<Integer> lottoNumbers;

    @BeforeEach
    void SetUp() {
        inputValidator = new InputValidator();
        lottoNumbers = List.of(1,2,3,4,5,6);
    }

    @Test
    void 보너스_번호_입력_성공() {
        String validatedInput = "23";

        assertDoesNotThrow(() -> inputValidator.validateBonusNumber(validatedInput, lottoNumbers));
    }

    @Test
    void 보너스_번호_입력_중복예외() {
        String duplicatedInput = "2";

        assertThatThrownBy(() -> inputValidator.validateBonusNumber(duplicatedInput, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.NOT_DISTINCT_BONUS_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호_입력_문자예외() {
        String noNumberInput = "a";

        assertThatThrownBy(() -> inputValidator.validateBonusNumber(noNumberInput, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.NO_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호_입력_범위예외() {
        String outRangeInput = "100";

        assertThatThrownBy(() -> inputValidator.validateBonusNumber(outRangeInput, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputException.NOT_IN_RANGE_LOTTO_NUMBER.getMessage());
    }
}
