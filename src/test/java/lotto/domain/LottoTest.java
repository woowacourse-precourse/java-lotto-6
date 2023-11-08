package lotto.domain;

import lotto.LottoFixture;
import lotto.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumbers() {
        assertThatThrownBy(() -> new Lotto(List.of(44, 45, 46, 47, 48, 49)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("당첨 기준에 맞게 등수를 구한다.")
    class RankWithWinningLotto {
        private void assertLottoRank(final Lotto lotto, final Rank expected) {
            Lotto winningLotto = LottoFixture.STANDARD;
            int bonus = LottoFixture.BONUS;
            assertEquals(lotto.rank(winningLotto, bonus), expected);
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
            assertLottoRank(LottoFixture.ONE.toLotto(), Rank.BLANK);
        }
    }
}