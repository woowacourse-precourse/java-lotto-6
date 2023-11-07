package lotto.lottoGame;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.lottoGame.rank.Rank;
import lotto.lottoGame.rank.RankCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultCalculratorTest {
    ResultCalculrator resultCalculrator;

    @BeforeEach
    void setup() {
        this.resultCalculrator = new ResultCalculrator();
    }

    @Test
    @DisplayName("1등을 한번 더해본다.")
    void 등수_1을_잘계산하는지() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.addCount(Rank.FIRST);

        long income = resultCalculrator.incomeSum(rankCounter);

        assertThat(income).isEqualTo(Rank.FIRST.getPrize());
    }

    @Test
    @DisplayName("1등을 두번 더해본다.")
    void 등수_1을_두번_잘계산하는지() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.addCount(Rank.FIRST);
        rankCounter.addCount(Rank.FIRST);

        long income = resultCalculrator.incomeSum(rankCounter);

        assertThat(income).isEqualTo(Rank.FIRST.getPrize() * 2);
    }

    @Test
    @DisplayName("2등을 한번 더해본다.")
    void 등수_2를_잘계산하는지() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.addCount(Rank.SECOND);

        long income = resultCalculrator.incomeSum(rankCounter);

        assertThat(income).isEqualTo(Rank.SECOND.getPrize());
    }

    @Test
    @DisplayName("2등을 두번 더해본다.")
    void 등수_2를_두번_잘계산하는지() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.addCount(Rank.SECOND);
        rankCounter.addCount(Rank.SECOND);

        long income = resultCalculrator.incomeSum(rankCounter);

        assertThat(income).isEqualTo(Rank.SECOND.getPrize() * 2);
    }

    @Test
    @DisplayName("3등을 한번 더해본다.")
    void 등수_3을_잘계산하는지() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.addCount(Rank.THIRD);

        long income = resultCalculrator.incomeSum(rankCounter);

        assertThat(income).isEqualTo(Rank.THIRD.getPrize());
    }

    @Test
    @DisplayName("3등을 두번 더해본다.")
    void 등수_3을_두번_잘계산하는지() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.addCount(Rank.THIRD);
        rankCounter.addCount(Rank.THIRD);

        long income = resultCalculrator.incomeSum(rankCounter);

        assertThat(income).isEqualTo(Rank.THIRD.getPrize() * 2);
    }

    @Test
    @DisplayName("4등을 한번 더해본다.")
    void 등수_4를_잘계산하는지() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.addCount(Rank.THIRD);

        long income = resultCalculrator.incomeSum(rankCounter);

        assertThat(income).isEqualTo(Rank.THIRD.getPrize());
    }

    @Test
    @DisplayName("4등을 두번 더해본다.")
    void 등수_4을_두번_잘계산하는지() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.addCount(Rank.FOURTH);
        rankCounter.addCount(Rank.FOURTH);

        long income = resultCalculrator.incomeSum(rankCounter);

        assertThat(income).isEqualTo(Rank.FOURTH.getPrize() * 2);
    }

    @Test
    @DisplayName("5등을 한번 더해본다.")
    void 등수_5를_잘계산하는지() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.addCount(Rank.FIFTH);

        long income = resultCalculrator.incomeSum(rankCounter);

        assertThat(income).isEqualTo(Rank.FIFTH.getPrize());
    }

    @Test
    @DisplayName("5등을 두번 더해본다.")
    void 등수_5를_두번_잘계산하는지() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.addCount(Rank.FIFTH);
        rankCounter.addCount(Rank.FIFTH);

        long income = resultCalculrator.incomeSum(rankCounter);

        assertThat(income).isEqualTo(Rank.FIFTH.getPrize() * 2);
    }
}