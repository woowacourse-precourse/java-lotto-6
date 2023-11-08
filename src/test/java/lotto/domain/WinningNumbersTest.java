package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.LottoFixture;
import lotto.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @DisplayName("보너스 번호가 1~45가 아닐 경우 예외를 반환한다.")
    @Test
    void createWinningNumberWithBonusNumberOutOfRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 46;
        assertThatThrownBy(() -> new WinningNumbers(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복될 경우 예외를 반환한다.")
    @Test
    void createWinningNumberWithDuplicatedBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 1;
        assertThatThrownBy(() -> new WinningNumbers(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 기준에 맞게 등수를 구한다.")
    @Nested
    class RankLotto {
        private void assertLottoRank(final Lotto lotto, final Rank expected) {
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
}
