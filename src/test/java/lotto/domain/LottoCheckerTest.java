package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoCheckerTest {

    @Test
    @DisplayName("보너스 번호가 없을 때, 당첨 번호와 로또 번호의 일치 개수 테스트")
    void testCountMatchingNumbers1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoAnswer lottoAnswer = new LottoAnswer("4,5,6,7,8,9");
        assertEquals(3, LottoChecker.countMatchingNumbers(lotto, lottoAnswer));
    }

    @Test
    @DisplayName("보너스 번호가 있을 떄, 당첨 번호와 로또 번호의 일치 개수 테스트")
    void testCountMatchingNumbers2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoAnswer lottoAnswer = new LottoAnswer("4,5,6,7,8,9", 1);
        assertEquals(4, LottoChecker.countMatchingNumbers(lotto, lottoAnswer));
    }

    @Test
    @DisplayName("보너스 번호의 일치 테스트")
    void testIsBonusNumberMatch() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(4);
        assertTrue(LottoChecker.isBonusNumberMatch(lotto, bonusNumber));
    }

    @Test
    @DisplayName("보너스 번호의 불일치 테스트")
    void testIsBonusNumberNotMatch() {
        Lotto lotto = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        BonusNumber bonusNumber = new BonusNumber(4);
        assertFalse(LottoChecker.isBonusNumberMatch(lotto, bonusNumber));
    }
}