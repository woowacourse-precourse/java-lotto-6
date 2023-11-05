package lotto;

import lotto.domain.BonusLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusLottoTest {
    @DisplayName("보너스 로또 입력값에 공백이 포함되면 예외가 발생한다.")
    @Test
    void inputBonusLottoWithSpaces() {
        String inputBonusLotto = "1 2";
        List<Integer> winnerNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusLotto(inputBonusLotto, winnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 입력값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void inputBonusLottoNotANumber() {
        String inputBonusLotto = "1A";
        List<Integer> winnerNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusLotto(inputBonusLotto, winnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 입력값의 첫 숫자가 0인 경우 예외가 발생한다.")
    @Test
    void inputBonusLottoWithLeadingZero() {
        String inputBonusLotto = "01";
        List<Integer> winnerNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusLotto(inputBonusLotto, winnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 입력값이 범위를 벗어나면 예외가 발생한다.")
    @Test
    void inputBonusLottoOutOfRange() {
        String inputBonusLotto = "50";
        List<Integer> winnerNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusLotto(inputBonusLotto, winnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 입력값이 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void inputBonusLottoDuplicate() {
        String inputBonusLotto = "1";
        List<Integer> winnerNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> new BonusLotto(inputBonusLotto, winnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}