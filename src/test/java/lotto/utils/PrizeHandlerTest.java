package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Paper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeHandlerTest {

    PrizeHandler fiveRank;
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
    }

    @Test
    @DisplayName("당첨 금액 설정하기")
    void test() {
        Paper paper = Paper.of("1,2,3,4,5,6", "10");
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        fiveRank.process(paper, lotto);

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
        Paper paper = Paper.of("1,2,3,4,5,6", "10");
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        fiveRank.process(paper, lotto);

        Lotto secondLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 20));

        fiveRank.process(paper, secondLotto);

        int totalPrizeCount = fiveRank.getTotalPrizeCount();
        assertThat(totalPrizeCount).isEqualTo(2_001_500_000);
    }

    @Test
    @DisplayName("당첨 금액 확인 - 하나도 없을 경우")
    void test3() {
        Paper paper = Paper.of("1,2,3,4,5,6", "10");
        Lotto lotto = Lotto.of(List.of(20, 21, 22, 23, 24, 25));
        fiveRank.process(paper, lotto);

        int totalPrizeCount = fiveRank.getTotalPrizeCount();
        assertThat(totalPrizeCount).isEqualTo(0);
    }
}