package lotto.view;

import static lotto.view.OutputView.printEarningRate;
import static lotto.view.OutputView.printLottoResult;
import static lotto.view.OutputView.printLottos;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
        Console.close();
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    void 발행된_티켓들은_오름차순으로_출력되어야_한다() {
        final List<Lotto> tickets = List.of(
            new Lotto(List.of(1, 3, 5, 7, 9, 11)),
            new Lotto(List.of(1, 7, 5, 6, 21, 11))
        );

        printLottos(tickets);

        assertThat(output()).contains(String.format("%d개를 구매했습니다.", 2));
        assertThat(output()).contains("[1, 3, 5, 7, 9, 11]");
        assertThat(output()).contains("[1, 5, 6, 7, 11, 21]");
    }

    @Test
    void 티켓_당첨_결과가_정상적으로_출력된다() {
        final LottoResult lottoResult = new LottoResult();
        lottoResult.increaseRankCount(LottoRank.SIX_MATCH);
        lottoResult.increaseRankCount(LottoRank.FIVE_MATCH_WITH_BONUS);
        lottoResult.increaseRankCount(LottoRank.FIVE_MATCH_WITH_BONUS);

        printLottoResult(lottoResult);

        assertThat(output()).contains("3개 일치 (5,000원) - 0개");
        assertThat(output()).contains("4개 일치 (50,000원) - 0개");
        assertThat(output()).contains("5개 일치 (1,500,000원) - 0개");
        assertThat(output()).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 2개");
        assertThat(output()).contains("6개 일치 (2,000,000,000원) - 1개");
    }

    @Test
    void 티켓_당첨_결과의_수익률을_출력한다() {
        final double earningRate = 5000 * 100.0 / 8000;

        printEarningRate(earningRate);

        assertThat(output()).contains("총 수익률은 62.5%입니다.");
    }

}