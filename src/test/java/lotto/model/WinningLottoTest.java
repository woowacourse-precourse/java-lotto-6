package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void createWinningLotto() {
        WinningLotto winningLotto = WinningLotto.getInstance();

        // 유효한 로또 번호로 테스트
        assertDoesNotThrow(() -> winningLotto.createWinningLotto("1, 2, 3, 4, 5, 6"));

        // 유효하지 않은 로또 번호로 테스트 (예: 범위를 벗어남)
        assertThrows(IllegalArgumentException.class, () -> winningLotto.createWinningLotto("1, 2, 3, 4, 5, 70"));

        // 유효하지 않은 로또 번호로 테스트 (예: 문자 포함)
        assertThrows(IllegalArgumentException.class, () -> winningLotto.createWinningLotto("1, 2, 3, 4, 5, a"));
    }

    @Test
    void createBonusNumber() {
        WinningLotto winningLotto = WinningLotto.getInstance();
        winningLotto.createWinningLotto("1, 2, 3, 4, 5, 6");
        // 유효한 보너스 번호로 테스트
        assertDoesNotThrow(() -> winningLotto.createBonusNumber("7"));

        // 유효하지 않은 보너스 번호로 테스트 (예: 범위를 벗어남)
        assertThrows(IllegalArgumentException.class, () -> winningLotto.createBonusNumber("70"));

        // 유효하지 않은 보너스 번호로 테스트 (예: 문자 포함)
        assertThrows(IllegalArgumentException.class, () -> winningLotto.createBonusNumber("a"));
    }

}
