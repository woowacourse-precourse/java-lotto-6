package lotto.utils;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Paper;
import lotto.domain.proxy.PrizeHandler;
import lotto.domain.proxy.PrizeHandlerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeHandlerTest {

    PrizeHandler fiveRank;
    Lotto lotto;
    @BeforeEach
    void setUp() {
        fiveRank = PrizeHandlerImpl.of(3, 5_000, false);
        PrizeHandler fourRank = PrizeHandlerImpl.of(4, 50_000, false);
        PrizeHandler threeRank = PrizeHandlerImpl.of(5, 1_500_000, false);
        PrizeHandler twoRank = PrizeHandlerImpl.of(5, 30_000_000, true);
        PrizeHandler oneRank = PrizeHandlerImpl.of(6, 2_000_000_000, false);

        fiveRank.setNextPrizeHandler(fourRank);
        fourRank.setNextPrizeHandler(threeRank);
        threeRank.setNextPrizeHandler(twoRank);
        twoRank.setNextPrizeHandler(oneRank);

        lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨 금액 설정하기")
    void test() {
        Paper paper = Paper.of(lotto, Bonus.of(10));
        Lotto randomLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        fiveRank.process(paper, randomLotto);

        String result = fiveRank.printWinningStatistics();
        String expected = """
                6개 일치 (2,000,000,000원) - 1개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                4개 일치 (50,000원) - 0개
                3개 일치 (5,000원) - 0개
                """;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("당첨 금액 확인")
    void test2() {
        Paper paper = Paper.of(lotto, Bonus.of(10));
        Lotto randomLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        fiveRank.process(paper, randomLotto);

        Lotto randomSecondLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 20));

        fiveRank.process(paper, randomSecondLotto);

        int totalPrizeCount = fiveRank.getTotalPrizeCount();
        assertThat(totalPrizeCount).isEqualTo(2_001_500_000);
    }

    @Test
    @DisplayName("당첨 금액 확인 - 하나도 없을 경우")
    void test3() {
        Paper paper = Paper.of(lotto, Bonus.of(10));
        Lotto randomLotto = Lotto.of(List.of(20, 21, 22, 23, 24, 25));
        fiveRank.process(paper, randomLotto);

        int totalPrizeCount = fiveRank.getTotalPrizeCount();
        assertThat(totalPrizeCount).isEqualTo(0);
    }

    @Test
    @DisplayName("수익률 계산")
    void test4() {
        Paper paper = Paper.of(lotto, Bonus.of(7));
        Lotto randomLotto = Lotto.of(List.of(8, 21, 23, 41, 42, 43));
        fiveRank.process(paper, randomLotto);

        Lotto secondLotto = Lotto.of(List.of(3, 5, 11, 16, 32, 38));
        fiveRank.process(paper, secondLotto);

        Lotto thirdLotto = Lotto.of(List.of(7, 11, 16, 35, 36, 44));
        fiveRank.process(paper, thirdLotto);

        Lotto fourthLotto = Lotto.of(List.of(1, 8, 11, 31, 41, 42));
        fiveRank.process(paper, fourthLotto);

        Lotto fifthLotto = Lotto.of(List.of(13, 14, 16, 38, 42, 45));
        fiveRank.process(paper, fifthLotto);

        Lotto sixthLotto = Lotto.of(List.of(7, 11, 30, 40, 42, 43));
        fiveRank.process(paper, sixthLotto);

        Lotto seventhLotto = Lotto.of(List.of(2, 13, 22, 32, 38, 45));
        fiveRank.process(paper, seventhLotto);

        Lotto eighthLotto = Lotto.of(List.of(1, 3, 5, 14, 22, 45));
        fiveRank.process(paper, eighthLotto);

        double earnRate = fiveRank.earnRate(8000);
        assertThat(earnRate).isEqualTo(62.5);
    }
}