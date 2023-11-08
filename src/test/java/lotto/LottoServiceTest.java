package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


public class LottoServiceTest extends NsTest {

    @Test
    void 당첨_통계_계산_Test() {
        LottoService lottoService = new LottoService();
        int number = 5;
        boolean bonus = false;
        lottoService.setWinStatistic(number, bonus);
        Assertions.assertThat(Ranking.THIRD.getRankingNumber()).isEqualTo(1);
    }

    @Test
    void 수익률_계산_Test(){
        LottoService lottoService = new LottoService();
        int price = 8000;
        Ranking.FIFTH.setRankingNumber(1);
        Assertions.assertThat(lottoService.calculateProfit(price)).isEqualTo(62.5);
    }

    @Test
    void 로또_리스트_생성_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,3,5,7,9,2", "8");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]"
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }

    @Test
    void 로또_리스트_비교_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("5000", "1,3,5,7,9,2", "8");
                    assertThat(output()).contains(
                            "5개를 구매했습니다.",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 5, 7, 9),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
