package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    enum CorrectWinningTier {
        FIRST, SECOND, THIRD, FOUR, FIFTH, RETIER, NONE
    }

    @DisplayName("일치하는 번호 갯수가 6개일 때 1등인지 검증")
    @Test
    void correctWinningCountSixThenFirstWinningTier() {
        //given
        long correctWinningCount = 6;
        boolean correctBonusCount = false;

        //when
        WinningStatistics winningStatistics = WinningStatistics.confirm(correctWinningCount, correctBonusCount);

        //then
        Assertions.assertThat(winningStatistics.name()).isEqualTo(CorrectWinningTier.FIRST.name());
    }

    @DisplayName("일치하는 번호 갯수가 5개이고, 보너스 번호를 맞췄을 때 2등인지 검증")
    @Test
    void correctWinningCountFiveAndOneBonusThenSecondWinningTier() {
        //given
        long correctWinningCount = 5;
        boolean correctBonusCount = true;

        //when
        WinningStatistics winningStatistics = WinningStatistics.confirm(correctWinningCount, correctBonusCount);

        //then
        Assertions.assertThat(winningStatistics.name()).isEqualTo(CorrectWinningTier.SECOND.name());
    }

    @DisplayName("일치하는 번호 갯수가 5개이고, 보너스 번호를 못 맞췄을 때 3등인지 검증")
    @Test
    void correctWinningCountFiveAndZeroBonusThenThirdWinningTier() {
        //given
        long correctWinningCount = 5;
        boolean correctBonusCount = false;

        //when
        WinningStatistics winningStatistics = WinningStatistics.confirm(correctWinningCount, correctBonusCount);

        //then
        Assertions.assertThat(winningStatistics.name()).isEqualTo(CorrectWinningTier.THIRD.name());
    }

    @DisplayName("일치하는 번호 갯수가 4개일 때 4등인지 검증")
    @Test
    void correctWinningCountFourThenFourWinningTier() {
        //given
        long correctWinningCount = 4;
        boolean correctBonusCount = false;

        //when
        WinningStatistics winningStatistics = WinningStatistics.confirm(correctWinningCount, correctBonusCount);

        //then
        Assertions.assertThat(winningStatistics.name()).isEqualTo(CorrectWinningTier.FOUR.name());
    }

    @DisplayName("일치하는 번호 갯수가 3개일 때 5등인지 검증")
    @Test
    void correctWinningCountThirdThenFifthWinningTier() {
        //given
        long correctWinningCount = 3;
        boolean correctBonusCount = false;

        //when
        WinningStatistics winningStatistics = WinningStatistics.confirm(correctWinningCount, correctBonusCount);

        //then
        Assertions.assertThat(winningStatistics.name()).isEqualTo(CorrectWinningTier.FIFTH.name());
    }

    @DisplayName("일치하는 번호 갯수가 2개일 때 리타티어 등수인지 검증")
    @Test
    void correctWinningCountTwoThenRetierWinningTier() {
        //given
        long correctWinningCount = 2;
        boolean correctBonusCount = false;

        //when
        WinningStatistics winningStatistics = WinningStatistics.confirm(correctWinningCount, correctBonusCount);

        //then
        Assertions.assertThat(winningStatistics.name()).isEqualTo(CorrectWinningTier.RETIER.name());
    }

    @DisplayName("일치하는 번호 갯수가 1개일 때 리타티어 등수인지 검증")
    @Test
    void correctWinningCountOneThenRetierWinningTier() {
        //given
        long correctWinningCount = 1;
        boolean correctBonusCount = false;

        //when
        WinningStatistics winningStatistics = WinningStatistics.confirm(correctWinningCount, correctBonusCount);

        //then
        Assertions.assertThat(winningStatistics.name()).isEqualTo(CorrectWinningTier.RETIER.name());
    }

    @DisplayName("일치하는 번호 갯수가 0개일 때 리타티어 등수인지 검증")
    @Test
    void correctWinningCountZeroThenRetierWinningTier() {
        //given
        long correctWinningCount = 0;
        boolean correctBonusCount = false;

        //when
        WinningStatistics winningStatistics = WinningStatistics.confirm(correctWinningCount, correctBonusCount);

        //then
        Assertions.assertThat(winningStatistics.name()).isEqualTo(CorrectWinningTier.RETIER.name());
    }

    @DisplayName("일치하는 번호 갯수가 6개일 때 보너스 번호가 1개일 때 등록되지 않은 등수인지 검증")
    @Test
    void correctWinningCountSixAndBonusOneThenRetierWinningTier() {
        //given
        long correctWinningCount = 6;
        boolean correctBonusCount = true;

        //when
        WinningStatistics winningStatistics = WinningStatistics.confirm(correctWinningCount, correctBonusCount);

        //then
        Assertions.assertThat(winningStatistics.name()).isEqualTo(CorrectWinningTier.NONE.name());
    }
}