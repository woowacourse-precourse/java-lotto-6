package lotto;

import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeTest {

    @Test
    @DisplayName("1등 상금이 올바르게 결정되는지 확인")
    void firstPrizeDetermination() {
        int matchCount = 6;
        boolean bonusMatch = false; // 보너스 번호는 1등 결정에 영향을 미치지 않음
        Prize result = Prize.determinePrize(matchCount, bonusMatch);
        assertEquals(Prize.FIRST, result);
    }

    @Test
    @DisplayName("보너스 번호 일치 시 2등 상금이 올바르게 결정되는지 확인")
    void secondPrizeDeterminationWithBonus() {
        int matchCount = 5;
        boolean bonusMatch = true;
        Prize result = Prize.determinePrize(matchCount, bonusMatch);
        assertEquals(Prize.SECOND, result);
    }

    @Test
    @DisplayName("보너스 번호 불일치 시 3등 상금이 올바르게 결정되는지 확인")
    void thirdPrizeDeterminationWithoutBonus() {
        int matchCount = 5;
        boolean bonusMatch = false;
        Prize result = Prize.determinePrize(matchCount, bonusMatch);
        assertEquals(Prize.THIRD, result);
    }

    @Test
    @DisplayName("4등 상금이 올바르게 결정되는지 확인")
    void fourthPrizeDetermination() {
        int matchCount = 4;
        boolean bonusMatch = false; // 보너스 번호는 4등 결정에 영향을 미치지 않음
        Prize result = Prize.determinePrize(matchCount, bonusMatch);
        assertEquals(Prize.FOURTH, result);
    }

    @Test
    @DisplayName("5등 상금이 올바르게 결정되는지 확인")
    void fifthPrizeDetermination() {
        int matchCount = 3;
        boolean bonusMatch = false; // 보너스 번호는 5등 결정에 영향을 미치지 않음
        Prize result = Prize.determinePrize(matchCount, bonusMatch);
        assertEquals(Prize.FIFTH, result);
    }

    @Test
    @DisplayName("상금이 없을 경우 올바르게 결정되는지 확인")
    void noPrizeDetermination() {
        int matchCount = 2;
        boolean bonusMatch = false;
        Prize result = Prize.determinePrize(matchCount, bonusMatch);
        assertEquals(Prize.NONE, result);
    }
}