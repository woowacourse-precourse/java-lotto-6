package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.MyTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("출력 뷰 테스트")
class OutputViewTest extends MyTest {

    @Test
    void 사용자가_구매한_모든_로또를_출력해라 () {
        //given
        List<List<Integer>> allLotto = List.of(
                List.of(1,12,14,21,35,43),
                List.of(4,9,18,21,35,44),
                List.of(3,15,18,29,38,44),
                List.of(1,4,18,21,35,44)
        );
        String expected = """
                [1, 12, 14, 21, 35, 43]
                [4, 9, 18, 21, 35, 44]
                [3, 15, 18, 29, 38, 44]
                [1, 4, 18, 21, 35, 44]
                """;

        //when
        OutputView.printAllLotto(allLotto);

        //then
        assertThat(output()).isEqualTo(expected);
    }

    @Test
    void 당첨_결과를_출력하라 () {
        //given
        Map<Integer, Integer> prizeResult = new LinkedHashMap<>();
        prizeResult.put(5_000, 1);
        prizeResult.put(50_000, 1);
        prizeResult.put(1_500_000, 1);
        prizeResult.put(30_000_000, 1);
        prizeResult.put(2_000_000_000, 1);
        String expected = """
                
                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 1개
                5개 일치 (1,500,000원) - 1개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                6개 일치 (2,000,000,000원) - 1개
                """;

        //when
        OutputView.printPrizeResult(prizeResult);

        //then
        assertThat(output()).isEqualTo(expected);
    }

    @Test
    void 총_수익률을_출력하라 () {
        //given
        double profit = 31.692;

        //when
        OutputView.printLottoProfit(profit);

        //then
        assertThat(output()).isEqualTo("총 수익률은 31.7%입니다.\n");
    }
}
