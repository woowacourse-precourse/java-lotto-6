package lotto.validator.view_layer;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.ErrorMessage.WINNING_LOTTO_CONTAIN_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberValidatorTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 일치하는것이 있으면 안된다")
    void validate() {
        Lotto winningLotto = new Lotto(List.of(21,22,23,24,25,26));

        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator(winningLotto);

        assertThatThrownBy(() -> bonusNumberValidator.validate("23"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_LOTTO_CONTAIN_BONUS_NUMBER);
    }
}