package lotto;

import org.junit.jupiter.api.DisplayName;
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

    private void assertLottoRank(Lotto lotto, Rank expected) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        assertEquals(lotto.rank(winningLotto, bonus), expected);
    }

    @DisplayName("6개가 맞을 경우 1등이다.")
    @Test
    void sixToFirst() {
        assertLottoRank(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST);
    }

    @DisplayName("5개가 맞고 보너스 번호가 맞을 경우 2등이다.")
    @Test
    void fiveWithBonusToSecond() {
        assertLottoRank(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND);
    }

    @DisplayName("5개가 맞고 보너스 번호가 틀릴 경우 3등이다.")
    @Test
    void fiveWithOutBonusToThird() {
        assertLottoRank(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Rank.THIRD);
    }

    @DisplayName("4개가 맞을 경우 4등이다.")
    @Test
    void fourToFourth() {
        assertLottoRank(new Lotto(List.of(1, 2, 3, 4, 7, 8)), Rank.FOURTH);
    }

    @DisplayName("3개가 맞을 경우 5등이다.")
    @Test
    void ThreeToFifth() {
        assertLottoRank(new Lotto(List.of(1, 2, 3, 7, 8, 9)), Rank.FIFTH);
    }

    @DisplayName("2개가 맞을 경우 낙첨이다.")
    @Test
    void TwoToBlank() {
        assertLottoRank(new Lotto(List.of(1, 2, 8, 9, 10, 11)), Rank.BLANK);
    }

    @DisplayName("1개가 맞을 경우 낙첨이다.")
    @Test
    void OneToBlank() {
        assertLottoRank(new Lotto(List.of(1, 8, 9, 10, 11, 12)), Rank.BLANK);
    }

    @DisplayName("0개가 맞을 경우 낙첨이다.")
    @Test
    void NoneToBlank() {
        assertLottoRank(new Lotto(List.of(8, 9, 10, 11, 12, 13)), Rank.BLANK);
    }
}