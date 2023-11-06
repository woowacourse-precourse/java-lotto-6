package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.LottoFixture;
import lotto.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    private void assertLottoRank(Lotto lotto, Rank expected) {
        WinningNumbers winningNumbers = LottoFixture.standard();
        assertEquals(winningNumbers.rank(lotto), expected);
    }
    @DisplayName("6개가 맞을 경우 1등이다.")
    @Test
    void sixToFirst() {
        assertLottoRank(LottoFixture.SIX.toLotto(), Rank.FIRST);
    }

    @DisplayName("5개가 맞고 보너스 번호가 맞을 경우 2등이다.")
    @Test
    void fiveWithBonusToSecond() {
        assertLottoRank(LottoFixture.FIVE_WITH_BONUS.toLotto(), Rank.SECOND);
    }

    @DisplayName("5개가 맞고 보너스 번호가 틀릴 경우 3등이다.")
    @Test
    void fiveWithOutBonusToThird() {
        assertLottoRank(LottoFixture.FIVE_WITHOUT_BONUS.toLotto(), Rank.THIRD);
    }

    @DisplayName("4개가 맞을 경우 4등이다.")
    @Test
    void fourToFourth() {
        assertLottoRank(LottoFixture.FOUR.toLotto(), Rank.FOURTH);
    }

    @DisplayName("3개가 맞을 경우 5등이다.")
    @Test
    void ThreeToFifth() {
        assertLottoRank(LottoFixture.THREE.toLotto(), Rank.FIFTH);
    }

    @DisplayName("2개가 맞을 경우 낙첨이다.")
    @Test
    void TwoToBlank() {
        assertLottoRank(LottoFixture.TWO.toLotto(), Rank.BLANK);
    }

    @DisplayName("1개가 맞을 경우 낙첨이다.")
    @Test
    void OneToBlank() {
        assertLottoRank(LottoFixture.ONE.toLotto(), Rank.BLANK);
    }

    @DisplayName("0개가 맞을 경우 낙첨이다.")
    @Test
    void NoneToBlank() {
        assertLottoRank(LottoFixture.NONE.toLotto(), Rank.BLANK);
    }
}
