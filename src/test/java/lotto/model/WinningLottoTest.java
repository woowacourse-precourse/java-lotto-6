package lotto.model;

import static lotto.error.ErrorMessage.NOT_UNIQUE_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.WinningGrade;
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

    @Test
    @DisplayName("당첨 로또와 구매 로또를 비교해서 당첨 등급을 구한다.")
    void matchLotto_WinningGrade() {
        // Given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("8");
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto purchaseLotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));

        // When
        WinningGrade result = winningLotto.matchLotto(purchaseLotto);

        // Then
        assertThat(result).isEqualTo(WinningGrade.FOURTH_GRADE);
    }

}