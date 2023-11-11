package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.services.Buy;
import lotto.services.LottoStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    OutputView outputView;
    Buy buy;
    List<List<Integer>> buyLottoNumbers;

    @BeforeEach
    void setUp() {
        buyLottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18)
        );
        outputView = new OutputView();
        buy = new Buy(buyLottoNumbers);
    }

    @DisplayName("당첨 통계 메시지 확인")
    @Test
    void printToPrizeDetails() {
        LottoStats lottoStats = new LottoStats();

        String actual = outputView.printToPrizeDetails(lottoStats.getStatsMap(), lottoStats.getEarningRate());

        assertThat(actual).contains("당첨 통계");
        assertThat(actual).contains("---");
        assertThat(actual).contains("3개 일치 (5,000원) - 0개");
        assertThat(actual).contains("4개 일치 (50,000원) - 0개");
        assertThat(actual).contains("5개 일치 (1,500,000원) - 0개");
        assertThat(actual).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        assertThat(actual).contains("6개 일치 (2,000,000,000원) - 0개");
        assertThat(actual).contains("총 수익률은 0.0%입니다.");
    }

    @DisplayName("구매한 로또 메시지 확인")
    @Test
    void printToBuyLotto() {
        String actual = outputView.printToBuyLotto(buyLottoNumbers, buyLottoNumbers.size());
        System.out.println(actual);

        assertThat(actual).contains("[1, 2, 3, 4, 5, 6]");
        assertThat(actual).contains("[7, 8, 9, 10, 11, 12]");
        assertThat(actual).contains("[13, 14, 15, 16, 17, 18]");
    }
}