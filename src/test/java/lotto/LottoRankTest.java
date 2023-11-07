package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @DisplayName("6개가 일치한다면 1등 결과를 반환한다.")
    @Test
    void generateLottoRankIfMatchNumberSix() {
        // given
        int matchNumber = 6;
        boolean isBonus = false;

        // when
        LottoRank lottoRank = LottoRank.ofMatchNumber(matchNumber, isBonus);

        // then
        assertEquals(LottoRank.FIRST, lottoRank);
    }

    @DisplayName("5개가 일치하면서 보너스 결과가 맞으면 2등 결과를 반환한다.")
    @Test
    void generateLottoRankIfMatchNumberFiveAndBonusIsTrue() {
        // given
        int matchNumber = 5;
        boolean isBonus = true;

        // when
        LottoRank lottoRank = LottoRank.ofMatchNumber(matchNumber, isBonus);

        // then
        assertEquals(LottoRank.SECOND, lottoRank);
    }

    @DisplayName("5개가 일치하면서 보너스 결과가 맞지 않으면 3등 결과를 반환한다.")
    @Test
    void generateLottoRankIfMatchNumberFiveAndBonusIsFalse() {
        // given
        int matchNumber = 5;
        boolean isBonus = false;

        // when
        LottoRank lottoRank = LottoRank.ofMatchNumber(matchNumber, isBonus);

        // then
        assertEquals(LottoRank.THIRD, lottoRank);
    }

    @DisplayName("4개가 일치하면 4등 결과를 반환한다.")
    @Test
    void generateLottoRankIfMatchNumberFour() {
        // given
        int matchNumber = 4;
        boolean isBonus = false;

        // when
        LottoRank lottoRank = LottoRank.ofMatchNumber(matchNumber, isBonus);

        // then
        assertEquals(LottoRank.FOURTH, lottoRank);
    }

    @DisplayName("3개가 일치하면 5등 결과를 반환한다.")
    @Test
    void generateLottoRankIfMatchNumberThree() {
        // given
        int matchNumber = 3;
        boolean isBonus = false;

        // when
        LottoRank lottoRank = LottoRank.ofMatchNumber(matchNumber, isBonus);

        // then
        assertEquals(LottoRank.FIFTH, lottoRank);
    }

    @DisplayName("2개가 일치하면 LottoRank 는 NONE 을 반환한다.")
    @Test
    void generateLottoRankIfMatchNumberTwo() {
        // given
        int matchNumber = 2;
        boolean isBonus = false;

        // when
        LottoRank lottoRank = LottoRank.ofMatchNumber(matchNumber, isBonus);

        // then
        assertEquals(LottoRank.NONE, lottoRank);
    }

    @DisplayName("1개가 일치하면 LottoRank 는 NONE 을 반환한다.")
    @Test
    void generateLottoRankIfMatchNumberOne() {
        // given
        int matchNumber = 1;
        boolean isBonus = false;

        // when
        LottoRank lottoRank = LottoRank.ofMatchNumber(matchNumber, isBonus);

        // then
        assertEquals(LottoRank.NONE, lottoRank);
    }

    @DisplayName("일치하는 개수가 없으면 LottoRank 는 NONE 을 반환한다.")
    @Test
    void generateLottoRankIfMatchNumberZero() {
        // given
        int matchNumber = 0;
        boolean isBonus = false;

        // when
        LottoRank lottoRank = LottoRank.ofMatchNumber(matchNumber, isBonus);

        // then
        assertEquals(LottoRank.NONE, lottoRank);
    }

}