package lotto.model;

import static lotto.error.ErrorMessage.NOT_UNIQUE_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호에 있는 값으로 보너스 번호를 만들면 예외가 발생한다.")
    void createWinningLotto_DuplicatedBonusNumber_Exception() {
        // Given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("3");

        // When & Then
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_UNIQUE_BONUS_NUMBER.getMessage());
    }

}