package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    private LottoManager lottoManager;

    @BeforeEach
    public void setUp() {
        lottoManager = LottoManager.getInstance();
    }

    @DisplayName("당첨 번호를 세팅하고 가져오는 기능 테스트")
    @Test
    public void given_SetWinningNumbers_when_GetWinningNumbers_then_ReturnsSetNumbers() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        lottoManager.setWinningNumbers(winningNumbers);

        assertEquals(winningNumbers, lottoManager.getWinningNumbers());
    }

    @DisplayName("보너스 번호를 세팅하고 가져오는 기능 테스트")
    @Test
    public void given_setBonusNum_when_GetBonusNum_then_returnSetBonusNum() {
        int bonusNum = 25;
        lottoManager.setBonusNum(bonusNum);

        assertEquals(bonusNum, lottoManager.getBonusNum());
    }

    @DisplayName("당첨 번호 세팅 시 유효성 검사 실패 테스트")
    @Test
    public void given_winningNumbers_when_SetWinningNumbers_then_ThrowsIllegalArgumentException() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        assertThrows(IllegalArgumentException.class, () -> lottoManager.setWinningNumbers(invalidNumbers));
    }

    @DisplayName("보너스 번호 세팅 시 유효성 검사 실패 테스트")
    @Test
    public void given_InvalidBonusNum_when_SetBonusNum_then_ThrowsIllegalArgumentException() {
        int bonusNum = 0;

        assertThrows(IllegalArgumentException.class, () -> lottoManager.setBonusNum(bonusNum));
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 유효성 검사 실패 테스트")
    @Test
    public void given_DuplicateBonusNum_when_SetBonusNum_then_ThrowsIllegalArgumentException() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        lottoManager.setWinningNumbers(winningNumbers);

        int duplicateBonusNum = 6;
        assertThrows(IllegalArgumentException.class, () -> lottoManager.setBonusNum(duplicateBonusNum));
    }
}