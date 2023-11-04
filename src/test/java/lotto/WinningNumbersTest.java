package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    private void assertLottoRank(Lotto lotto, RANK expected) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonus);
        assertEquals(winningNumbers.rank(lotto), expected);
    }
    @DisplayName("6개가 맞을 경우 1등이다.")
    @Test
    void sixToFirst() {
        assertLottoRank(new Lotto(List.of(1, 2, 3, 4, 5, 6)), RANK.FIRST);
    }

    @DisplayName("5개가 맞고 보너스 번호가 맞을 경우 2등이다.")
    @Test
    void fiveWithBonusToSecond() {
        assertLottoRank(new Lotto(List.of(1, 2, 3, 4, 5, 7)), RANK.SECOND);
    }

    @DisplayName("5개가 맞고 보너스 번호가 틀릴 경우 3등이다.")
    @Test
    void fiveWithOutBonusToThird() {
        assertLottoRank(new Lotto(List.of(1, 2, 3, 4, 5, 8)), RANK.THIRD);
    }

    @DisplayName("4개가 맞을 경우 4등이다.")
    @Test
    void fourToFourth() {
        assertLottoRank(new Lotto(List.of(1, 2, 3, 4, 7, 8)), RANK.FOURTH);
    }

    @DisplayName("3개가 맞을 경우 5등이다.")
    @Test
    void ThreeToFifth() {
        assertLottoRank(new Lotto(List.of(1, 2, 3, 7, 8, 9)), RANK.FIFTH);
    }

    @DisplayName("2개가 맞을 경우 낙첨이다.")
    @Test
    void TwoToBlank() {
        assertLottoRank(new Lotto(List.of(1, 2, 8, 9, 10, 11)), RANK.BLANK);
    }

    @DisplayName("1개가 맞을 경우 낙첨이다.")
    @Test
    void OneToBlank() {
        assertLottoRank(new Lotto(List.of(1, 8, 9, 10, 11, 12)), RANK.BLANK);
    }

    @DisplayName("0개가 맞을 경우 낙첨이다.")
    @Test
    void NoneToBlank() {
        assertLottoRank(new Lotto(List.of(8, 9, 10, 11, 12, 13)), RANK.BLANK);
    }
}
