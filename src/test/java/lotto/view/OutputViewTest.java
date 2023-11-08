package lotto.view;

import lotto.domain.Cash;
import lotto.domain.Profit;
import lotto.domain.Rank;
import lotto.domain.WinningYield;
import lotto.dto.Ranks;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class OutputViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("출력 형식에 맞추어 당첨 내역을 출력한다.")
    void displayWinningDetails() {
        // given
        Ranks ranks = new Ranks(List.of(Rank.FIFTH, Rank.FIFTH, Rank.FOURTH));
        Cash cash = new Cash(8000);
        Profit profit = new Profit();
        profit.calculateAmount(ranks);
        WinningYield winningYield = new WinningYield(cash, profit);

        // when
        OutputView.displayWinningDetails(ranks, winningYield);

        // then
        String capturedOutput = outputStreamCaptor.toString().trim();
        Assertions.assertThat(capturedOutput).isEqualTo("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 2개\n" +
                "4개 일치 (50,000원) - 1개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 750.0%입니다.");
    }
}