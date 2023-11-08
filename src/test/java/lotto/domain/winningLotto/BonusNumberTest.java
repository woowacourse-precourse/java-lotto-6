package lotto.domain.winningLotto;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createWinningNumbers_Fail_ByBonusNumberIsLessThanMinimum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage()
                        .formatted(
                                LottoConstants.MIN_LOTTO_NUMBER.getValue(),
                                LottoConstants.MAX_LOTTO_NUMBER.getValue()
                        )
                );
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void createWinningNumbers_Fail_ByBonusNumberIsMoreThanMaximum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new BonusNumber(77))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage()
                        .formatted(
                                LottoConstants.MIN_LOTTO_NUMBER.getValue(),
                                LottoConstants.MAX_LOTTO_NUMBER.getValue()
                        )
                );
    }
}
