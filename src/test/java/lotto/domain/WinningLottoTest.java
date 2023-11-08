package lotto.domain;

import lotto.validation.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
class WinningLottoTest {

    Validation validation = new Validation();

    @DisplayName("당첨번호 입력시 중복 값이 존재하면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateNum() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> validation.checkWinningLottoDuplicate(winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력시 0 - 45 사이 값이 아니면 예외가 발생한다.")
    @Test
    void createWinningLottoOverRange() {
        List<Integer> winningLotto = List.of(0, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> validation.checkWinningLottoRange(winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력시 잘못된 값을 입력 했을 때 값이 아니면 예외가 발생한다.")
    @Test
    void createWinningLottoWrongNum() {
        String winningLotto = "6j";
        assertThatThrownBy(() -> validation.checkWinningNum(winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력시 당첨 번호에 값이 존재 하면 예외가 발생한다.")
    @Test
    void createBonusNumByContainWinningLotto() {
        List<Integer> winningLotto = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 6;
        assertThatThrownBy(() -> validation.checkBonusNumDuplicate(winningLotto, bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력시 0 - 45 사이 값이 아니면 예외가 발생한다.")
    @Test
    void createBonusNumByOverRange() {
        int bonusNum = 50;
        assertThatThrownBy(() -> validation.checkBonusNumRange(bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력시 잘못된 값을 입력 했을 때 예외가 발생한다.")
    @Test
    void createBonusNumByWrongNum() {
        String bonusNum = "45j";
        assertThatThrownBy(() -> validation.checkBonusNum(bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

