package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String DUPLICATE_WINNING_BONUS_NUMBER_ERROR = "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    private static final String NOT_INTEGER_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 정수여야 합니다.";
    private static final String INVALID_BONUS_NUMBER_RANGE_ERROR = "[ERROR] 보너스 번호는 %d부터 %d 사이의 수여야 합니다.";

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> WinningLotto.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_WINNING_BONUS_NUMBER_ERROR);
    }

    @DisplayName("보너스 번호가 정수가 아니면 예외가 발생한다.")
    @Test
    void bonusNumberByNotInteger() {
        assertThatThrownBy(() -> WinningLotto.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "7.1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER_BONUS_NUMBER_ERROR);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void bonusNumberByInvalidRange() {
        assertThatThrownBy(() -> WinningLotto.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(INVALID_BONUS_NUMBER_RANGE_ERROR, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }

    @DisplayName("당첨 번호 값 저장 확인")
    @Test
    void getWinningLotto() {
        WinningLotto winningLotto = WinningLotto.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "7");
        assertThat(winningLotto.getWinningLotto().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호 값 저장 확인")
    @Test
    void getBonusNumber() {
        WinningLotto winningLotto = WinningLotto.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "7");
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}
