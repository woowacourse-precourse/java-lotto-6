package lotto.global;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @DisplayName("보너스 번호가 로또번호와 겹치면 예외가 발생한다.")
    @Test
    void validateBonusNumberDuplicate() {
        // given
        Lotto winningLottoNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumberInt = 1;
        // when
        assertThatThrownBy(() -> Validator.validateBonusNumber(winningLottoNumber, bonusNumberInt))
                .isInstanceOf(CustomException.class);
    }

    @DisplayName("보너스 번호가 로또번호 범위를 벗어나면 예외가 발생한다.")
    @Test
    void validateBonusNumberRange() {
        // given
        Lotto winningLottoNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumberInt = 111;
        // when
        assertThatThrownBy(() -> Validator.validateBonusNumber(winningLottoNumber, bonusNumberInt))
                .isInstanceOf(CustomException.class);
    }
}