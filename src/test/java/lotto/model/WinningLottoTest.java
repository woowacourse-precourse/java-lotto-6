package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.utils.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest extends NsTest {
    WinningLotto winningLotto;
    @BeforeEach
    void setUp() {
        winningLotto = WinningLotto.getInstance();
    }


    @DisplayName("유효한 로또 번호")
    @Test
    void 유효한_로또_번호() {
        assertDoesNotThrow(() -> winningLotto.createWinningLotto("1, 2, 3, 4, 5, 6"));
    }

    @DisplayName("범위를 벗어난 로또 번호일 경우 예외가 발생한다")
    @Test
    void 범위_벗어난_로또_번호() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningLotto.createWinningLotto("1, 2, 3, 4, 5, 70"));
        assertThat(exception).hasMessage(ErrorMessages.OUT_OF_RANGE.toString());
    }

    @DisplayName("문자 포함한 로또 번호일 경우 예외가 발생한다")
    @Test
    void 문자_포함한_로또_번호() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningLotto.createWinningLotto("1, 2, 3, 4, 5, a"));
        assertThat(exception).hasMessage(ErrorMessages.NOT_INTEGER.toString());
    }

    @DisplayName("유효한 보너스 번호일 경우 예외가 발생한다")
    @Test
    void 유효한_보너스_번호() {
        winningLotto.createWinningLotto("1, 2, 3, 4, 5, 6");
        assertDoesNotThrow(() -> winningLotto.createBonusNumber("7"));
    }

    @DisplayName("범위를 벗어난 보너스 번호일 경우 예외가 발생한다")
    @Test
    void 범위_벗어난_보너스_번호() {
        winningLotto.createWinningLotto("1, 2, 3, 4, 5, 6");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningLotto.createBonusNumber("70"));
        assertThat(exception).hasMessage(ErrorMessages.OUT_OF_RANGE.toString());
    }

    @DisplayName("이미 로또 번호에 포함된 보너스 번호일 경우 예외가 발생한다")
    @Test
    void 이미_로또_번호에_포함된_보너스_번호() {
        winningLotto.createWinningLotto("1, 2, 3, 4, 5, 6");
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> winningLotto.createBonusNumber("6"));
        assertThat(exception).hasMessage(ErrorMessages.ALREADY_HAVE.toString());
    }

    @DisplayName("문자를 포함한 보너스 번호일 경우 예외가 발생한다")
    @Test
    void 문자_포함한_보너스_번호() {
        winningLotto.createWinningLotto("1, 2, 3, 4, 5, 6");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningLotto.createBonusNumber("a"));
        assertThat(exception).hasMessage(ErrorMessages.NOT_INTEGER.toString());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
