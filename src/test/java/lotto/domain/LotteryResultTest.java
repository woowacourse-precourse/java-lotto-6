package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LotteryResultTest {

    @Test
    @DisplayName("복권 결과와 올바른 액수가 매칭되는가")
    void winnerMoneyTest() {
        LotteryResult shouldFirst = LotteryResult.getWinnerMoneyOf(6, 0);
        LotteryResult shouldSecond = LotteryResult.getWinnerMoneyOf(5, 1);
        LotteryResult shouldThird = LotteryResult.getWinnerMoneyOf(5, 0);
        LotteryResult shouldForth = LotteryResult.getWinnerMoneyOf(4, 0);
        LotteryResult shouldFifth = LotteryResult.getWinnerMoneyOf(3, 0);
        LotteryResult shouldNothing1 = LotteryResult.getWinnerMoneyOf(2, 0);
        LotteryResult shouldNothing2 = LotteryResult.getWinnerMoneyOf(1, 0);
        LotteryResult shouldNothing3 = LotteryResult.getWinnerMoneyOf(0, 0);

        assertThat(shouldFirst.getLotteryMoney()).isEqualTo(2_000_000_000);
        assertThat(shouldSecond.getLotteryMoney()).isEqualTo(30_000_000);
        assertThat(shouldThird.getLotteryMoney()).isEqualTo(1_500_000);
        assertThat(shouldForth.getLotteryMoney()).isEqualTo(50_000);
        assertThat(shouldFifth.getLotteryMoney()).isEqualTo(5000);
        assertThat(shouldNothing1.getLotteryMoney()).isEqualTo(0);
        assertThat(shouldNothing2.getLotteryMoney()).isEqualTo(0);
        assertThat(shouldNothing3.getLotteryMoney()).isEqualTo(0);
    }

    @Test
    void lotteryResultStringTest() {

        String firstInfoString = LotteryResult.FIRST.toString();
        assertThat(firstInfoString).contains("6개 일치 (2,000,000,000원)");

        String secondInfoString = LotteryResult.SECOND.toString();
        assertThat(secondInfoString).contains("5개 일치, 보너스 볼 일치 (30,000,000원)");

    }

}