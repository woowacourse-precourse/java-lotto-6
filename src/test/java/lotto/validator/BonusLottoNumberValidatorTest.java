package lotto.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusLottoNumberValidatorTest {

    @DisplayName("문자가 입력되면 예외가 발생한다.")
    @Test
    void bonusLottoNumberInputString() {

    }

    @DisplayName("숫자가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void bonusLottoNumberOutOfRange() {

    }
    @DisplayName("숫자가 소수면 예외가 발생한다.")
    @Test
    void bonusLottoNumberNotInteger() {

    }
}