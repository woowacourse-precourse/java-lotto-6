package lotto.view;

import static lotto.constant.testConstant.BONUS_NUMBER_45;
import static lotto.constant.testConstant.LOTTO_1_TO_5_WITH_45;
import static lotto.constant.testConstant.LOTTO_1_TO_6;
import static lotto.constant.testConstant.LOTTO_3_TO_8;
import static lotto.constant.testConstant.LOTTO_7_TO_12;
import static lotto.domain.MatchingCase.NEW_GAME;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCollection;
import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.domain.Profit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private ByteArrayOutputStream outputStream;


    @BeforeEach
    void setup() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void check_lotto_count() {
        LottoCount lottoCount = LottoCount.from(2000);
        OutputView.printLottoCount(lottoCount.getCount());
        assertThat(outputStream.toString())
                .hasToString("2개를 구매했습니다.\n");
    }

    @Test
    void check_lotto_collection() {
        LottoCollection lottoCollection = LottoCollection.from(List.of(LOTTO_1_TO_6, LOTTO_7_TO_12));
        OutputView.printLottoCollection(lottoCollection.getLottoCollection());
        assertThat(outputStream.toString())
                .hasToString("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n");
    }

    @Test
    void check_result() {
        NEW_GAME.initMatchingCase();
        LottoCollection lottoCollection = LottoCollection.from(
                List.of(LOTTO_1_TO_5_WITH_45, LOTTO_1_TO_6, LOTTO_3_TO_8));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoCollection.applyResults(winningLotto, BONUS_NUMBER_45);
        OutputView.printResult(NEW_GAME.getResult());
        assertThat(outputStream.toString())
                .hasToString("당첨 통계\n"
                        + "---\n"
                        + "3개 일치 (5,000원) - 0개\n"
                        + "4개 일치 (50,000원) - 1개\n"
                        + "5개 일치 (1,500,000원) - 0개\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                        + "6개 일치 (2,000,000,000원) - 1개\n");
    }

    @Test
    void check_profit() {
        NEW_GAME.initMatchingCase();
        LottoResult lottoResult_1500000 = LottoResult.of(5, false);
        lottoResult_1500000.recordMatchingCaseResults();
        LottoResult lottoResult_30000000 = LottoResult.of(5, true);
        lottoResult_30000000.recordMatchingCaseResults();
        Profit profit = Profit.from(NEW_GAME.getResult(), 100000);

        OutputView.printProfit(profit.getProfit());

        assertThat(outputStream.toString())
                .hasToString("총 수익률은 31500.0%입니다.");
    }

}
