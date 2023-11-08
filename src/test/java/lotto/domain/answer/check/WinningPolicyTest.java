package lotto.domain.answer.check;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningPolicyTest {
    @Test
    @DisplayName("로또번호일치수와 보너스번호 여부에 따라 등수를 구합니다.")
    public void 등수구하기() {
        // GIVEN
        int count1 = 6;
        boolean hasBonusNumber1 = false;
        int count2 = 5;
        boolean hasBonusNumber2 = true;
        int count3 = 5;
        boolean hasBonusNumber3 = false;
        int count4 = 4;
        boolean hasBonusNumber4 = false;
        // WHEN
        int rank1 = WinningPolicy.getRank.apply(count1, hasBonusNumber1);
        int rank2 = WinningPolicy.getRank.apply(count2, hasBonusNumber2);
        int rank3 = WinningPolicy.getRank.apply(count3, hasBonusNumber3);
        int rank4 = WinningPolicy.getRank.apply(count4, hasBonusNumber4);
        // THEN
        assertEquals(1, rank1);
        assertEquals(2, rank2);
        assertEquals(3, rank3);
        assertEquals(4, rank4);
    }
}