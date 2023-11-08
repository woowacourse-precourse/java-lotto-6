package lotto.service;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberServiceTest {

    @org.junit.Test
    @DisplayName("당첨 번호가 올바르지 않은 경우 예외 발생")
    void 당첨_번호가_올바르지_않은_경우_예외_발생() {
        WinningNumberService winningNumberService = new WinningNumberService();
        assertThrows(IllegalArgumentException.class, () -> winningNumberService.setWinningNumbers("1,2,3,4,5"));
    }

    @Test
    @DisplayName("보너스 번호가 정수가 아닐 경우 예외 발생")
    void 보너스_번호가_정수가_아닐_경우_예외_발생() {
        WinningNumberService winningNumberService = new WinningNumberService();
        assertThrows(IllegalArgumentException.class, () -> winningNumberService.setBonusNumbers("abc"));
    }

    @Test
    @DisplayName("올바른 당첨 번호 설정")
    void 올바른_당첨_번호_설정() {
        WinningNumberService winningNumberService = new WinningNumberService();
        winningNumberService.setWinningNumbers("1,2,3,4,5,6");
        winningNumberService.setBonusNumbers("7");
        assertNotNull(winningNumberService.getLottoWinningNumber());
    }
}