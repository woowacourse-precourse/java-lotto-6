package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningRanking;
import lotto.domain.Lottos;
import lotto.dto.LottoWinningRakingCountMapDto;
import lotto.dto.LottosDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void beforeEach() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("로또 구매 개수 출력")
    void 로또_구매_개수_출력() {
        int purchaseCount = 2;

        outputView.responsePurchaseCount(purchaseCount);

        Assertions.assertThat(outContent.toString()).isEqualTo("\n2개를 구매했습니다.\n");

    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, 6",
            "7, 8, 9, 10, 11, 12",
            "13, 14, 15, 16, 17, 18"
    })
    @DisplayName("로또 구매 개수 출력 (1개, 단수)")
    void 구매한_로또_번호_출력(int num1, int num2, int num3, int num4, int num5, int num6) {
        List<Integer> lottoNumbers = Arrays.asList(num1, num2, num3, num4, num5, num6);
        Lotto lotto = new Lotto(lottoNumbers);
        Lottos lottos = new Lottos(List.of(lotto));

        outputView.responseUserNumbersSet(new LottosDto(lottos));

        Assertions.assertThat(outContent.toString()).isEqualTo("[" + num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5 + ", " + num6 + "]\n");
    }

    @Test
    @DisplayName("로또 구매 개수 출력 (3개, 복수)")
    void 구매한_로또_번호들_출력() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(13, 14, 15, 16, 17, 18);
        List<Integer> lottoNumbers3 = Arrays.asList(7, 8, 9, 10, 11, 1);
        List<Lotto> lottoSet = Arrays.asList(new Lotto(lottoNumbers1), new Lotto(lottoNumbers2), new Lotto(lottoNumbers3));
        Lottos lottos = new Lottos(lottoSet);

        outputView.responseUserNumbersSet(new LottosDto(lottos));

        Assertions.assertThat(outContent.toString()).isEqualTo(
                """
                        [1, 2, 3, 4, 5, 6]
                        [13, 14, 15, 16, 17, 18]
                        [1, 7, 8, 9, 10, 11]
                        """);
    }

    @Test
    @DisplayName("로또 당첨 통계 헤더 출력")
    void 로또_통계_헤더_출력() {
        outputView.responseWinningStatisticsHeader();

        Assertions.assertThat(outContent.toString()).isEqualTo("당첨 통계\n---\n");
    }

    @Test
    @DisplayName("로또 당첨 통계 바디 출력")
    void 로또_통계_바디_출력() {
        EnumMap<LottoWinningRanking, Integer> rankingCountMap = new EnumMap<>(LottoWinningRanking.class);
        rankingCountMap.put(LottoWinningRanking.FIFTH, 1);
        rankingCountMap.put(LottoWinningRanking.FOURTH, 0);
        rankingCountMap.put(LottoWinningRanking.THIRD, 0);
        rankingCountMap.put(LottoWinningRanking.SECOND, 0);
        rankingCountMap.put(LottoWinningRanking.FIRST, 0);

        outputView.responseWinningStatisticsBody(new LottoWinningRakingCountMapDto(rankingCountMap));

        String expectedOutput =
                """
                        3개 일치 (5,000원) - 1개
                        4개 일치 (50,000원) - 0개
                        5개 일치 (1,500,000원) - 0개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                        6개 일치 (2,000,000,000원) - 0개
                        """;
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("로또 수익률 출력")
    void 로또_수익률_출력() {
        double profit = 65.5;
        outputView.responseProfit(profit);
        Assertions.assertThat(outContent.toString()).isEqualTo("총 수익률은 65.5%입니다.\n");
    }

    @Test
    @DisplayName("로또 수익률 3자리 수마다 콤마 출력")
    void 로또_수익률_출력_3자리_수마다_콤마() {
        double profit = 1000000.5;
        outputView.responseProfit(profit);
        Assertions.assertThat(outContent.toString()).isEqualTo("총 수익률은 1,000,000.5%입니다.\n");
    }
}
