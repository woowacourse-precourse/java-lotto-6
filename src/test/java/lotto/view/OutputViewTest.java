package lotto.view;

import static lotto.domain.Ranking.*;
import static lotto.domain.Ranking.SIXTH;
import static lotto.utils.StringUtils.countOccurrences;
import static lotto.view.OutputView.WINNING_STATISTICS;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class OutputViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void beforeEach() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void afterEach() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("기능20 테스트 : 로또 0개를 구해 했을 때 구매 결과를 잘 출력한다.")
    void printPurchaseResultCorrectlyWhenPurchaseZeroLotto() {
        // given
        int totalPurchaseCount = 0;
        List<Lotto> lottoList = new ArrayList<>();

        // when
        OutputView.printPurchaseResult(lottoList);
        String result = outputStreamCaptor.toString();
        int count = countOccurrences(result, "[");

        // then
        assertThat(result).contains("0개를 구매했습니다.");
        assertThat(count).isEqualTo(0);
    }


    @Test
    @DisplayName("기능20 테스트 : 로또 1개를 구해 했을 때 구매 결과를 잘 출력한다.")
    void printPurchaseResultCorrectlyWhenPurchaseOneLotto() {
        // given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        // when
        OutputView.printPurchaseResult(lottoList);
        String result = outputStreamCaptor.toString();
        int count = countOccurrences(result, "[");

        // then
        assertThat(result).contains("1개를 구매했습니다.");
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("기능20 테스트 : 로또 5개를 구해 했을 때 구매 결과를 잘 출력한다.")
    void printPurchaseResultCorrectlyWhenPurchaseFiveLotto() {
        // given
        int purChaseCount = 5;
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < purChaseCount; i++) {
            lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }

        // when
        OutputView.printPurchaseResult(lottoList);
        String result = outputStreamCaptor.toString();
        int count = countOccurrences(result, "[");

        // then
        assertThat(result).contains("5개를 구매했습니다.");
        assertThat(count).isEqualTo(5);
    }

    @Test
    @DisplayName("기능35 테스트 : winningResult와 profitRate을 사용해 원하는 형식으로 출력한다.")
    void printStatisticsCorrectly() {
        // given
        HashMap<Ranking, Integer> winningResult = initWinningResult();
        winningResult.put(FIFTH, 1);
        double profitRate = 62.5;

        // when
        OutputView.printStatisticsResult(winningResult, profitRate);
        String result = outputStreamCaptor.toString();

        // then
        assertThat(result)
                .containsSubsequence("당첨 통계", "---")
                .containsSubsequence("- 1개", "- 0개", "- 0개", "- 0개", "- 0개")
                .containsSubsequence(WINNING_STATISTICS, "---", "총 수익률은", "62.5%입니다.");
    }

    @Test
    @DisplayName("기능35 테스트 : 하나도 당첨되지 않았을 때도 결과를 제대로 출력한다.")
    void printStatisticsCorrectlyWhenNoWinningLotto() {
        // given
        HashMap<Ranking, Integer> winningResult = initWinningResult();
        double profitRate = 0;

        // when
        OutputView.printStatisticsResult(winningResult, profitRate);
        String result = outputStreamCaptor.toString();

        // then
        assertThat(result)
                .containsSubsequence("당첨 통계", "---")
                .containsSubsequence("- 0개", "- 0개", "- 0개", "- 0개", "- 0개")
                .containsSubsequence(WINNING_STATISTICS, "---", "총 수익률은", "0.0%입니다.");
    }


    private HashMap<Ranking, Integer> initWinningResult() {
        // given
        HashMap<Ranking, Integer> winningResult = new HashMap<>();

        winningResult.put(FIRST, 0);
        winningResult.put(SECOND, 0);
        winningResult.put(THIRD, 0);
        winningResult.put(FORTH, 0);
        winningResult.put(FIFTH, 0);
        winningResult.put(SIXTH, 0);

        return winningResult;
    }

}