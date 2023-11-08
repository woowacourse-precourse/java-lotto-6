package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private LottoService lottoService;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        lottoService = LottoService.getInstance();
        winningNumbers = Arrays.asList(3, 12, 21, 25, 38, 42);
        bonusNumber = 45;
    }

    @Test
    @DisplayName("당첨번호가 전부 일치하면 1등이다.")
    void checkAllNumbersMatch() {
        List<Integer> userNumbers = Arrays.asList(3, 12, 21, 25, 38, 42);
        LottoRank result = lottoService.checkWinning(userNumbers, winningNumbers, bonusNumber);
        assertEquals(LottoRank.FIRST, result);
    }

    @Test
    @DisplayName("일치하는 숫자가 5개이고 보너스 번호가 일치할 경우 2등이다.")
    void checkFiveNumbersAndBonusMatch() {
        List<Integer> userNumbers = Arrays.asList(3, 12, 21, 25, 38, 45);
        LottoRank result = lottoService.checkWinning(userNumbers, winningNumbers, bonusNumber);
        assertEquals(LottoRank.SECOND, result);
    }

    @Test
    @DisplayName("일치하는 숫자가 5개인 경우 3등이다.")
    void checkFiveNumbersMatch() {
        List<Integer> userNumbers = Arrays.asList(3, 12, 21, 25, 38, 1);
        LottoRank result = lottoService.checkWinning(userNumbers, winningNumbers, bonusNumber);
        assertEquals(LottoRank.THIRD, result);
    }

    @Test
    @DisplayName("일치하는 숫자가 4개인 경우 4등이다.")
    void checkFourNumbersMatch() {
        List<Integer> userNumbers = Arrays.asList(3, 12, 21, 25, 1, 2);
        LottoRank result = lottoService.checkWinning(userNumbers, winningNumbers, bonusNumber);
        assertEquals(LottoRank.FOURTH, result);
    }

    @Test
    @DisplayName("일치하는 숫자가 3개인 경우 5등이다.")
    void checkThreeNumbersMatch() {
        List<Integer> userNumbers = Arrays.asList(3, 12, 21, 1, 2, 4);
        LottoRank result = lottoService.checkWinning(userNumbers, winningNumbers, bonusNumber);
        assertEquals(LottoRank.FIFTH, result);
    }

    @Test
    @DisplayName("일치하는 숫자가 3개 미만일 경우 당첨 금액은 없다.")
    void checkLessThanThreeNumbersMatch() {
        List<Integer> userNumbers = Arrays.asList(3, 12, 1, 2, 4, 6);
        LottoRank result = lottoService.checkWinning(userNumbers, winningNumbers, bonusNumber);
        assertEquals(LottoRank.NONE, result);
    }
}
