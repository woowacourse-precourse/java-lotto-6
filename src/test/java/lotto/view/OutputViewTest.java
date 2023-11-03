package lotto.view;

import lotto.domain.Ranking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

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
        String purchaseCount = "2";
        outputView.responsePurchaseCount(purchaseCount);
        Assertions.assertThat(outContent.toString()).isEqualTo("2개를 구매했습니다.\n");
    }

    @Test
    @DisplayName("로또 당첨 번호 출력")
    void 로또_당첨_번호_출력() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        outputView.responseWinningNumbers(winningNumbers);
        Assertions.assertThat(outContent.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n");
    }

    @Test
    @DisplayName("로또 당첨 통계 결과 출력")
    void 로또_당첨_통계_출력() {
        int count = 0; // 각 로또 당첨된 개수 0으로 가정

        List<String> statistics = Arrays.stream(Ranking.values())
                .map(ranking -> {
                    String result = String.format("%d개 일치 (%,d원) - %d개", ranking.getMatchedNumberCount()
                            , ranking.getWinningAmount(), count);
                    if (ranking.getNeedsBonusNumber()) {
                        result = String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", ranking.getMatchedNumberCount()
                                , ranking.getWinningAmount(), count);
                    }
                    return result;
                })
                .toList();
        String statisticsString = String.join("\n", statistics);

        outputView.responseWinningStatisticsHeader();
        outputView.responseWinningStatisticsBody(statisticsString);
        Assertions.assertThat(outContent.toString()).isEqualTo("""
                당첨 통계
                ---
                3개 일치 (5,000원) - 0개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개""");
    }

    @Test
    @DisplayName("로또 수익률 출력")
    void 로또_수익률_출력() {
        String totalReturn = "65.5";
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        String formattedTotalReturn = decimalFormat.format(Double.parseDouble(totalReturn));
        outputView.responseTotalReturn(formattedTotalReturn);
        Assertions.assertThat(outContent.toString()).isEqualTo("총 수익률은 65.5%입니다.\n");
    }

    @Test
    @DisplayName("로또 수익률 3자리 수마다 콤마 출력")
    void 로또_수익률_출력_3자리_수마다_콤마() {
        String totalReturn = "1000000.5";
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        String formattedTotalReturn = decimalFormat.format(Double.parseDouble(totalReturn));
        outputView.responseTotalReturn(formattedTotalReturn);
        Assertions.assertThat(outContent.toString()).isEqualTo("총 수익률은 1,000,000.5%입니다.\n");
    }
}
