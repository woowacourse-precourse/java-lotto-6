package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OutputViewTest {
    OutputView outputView = new OutputView();

    @DisplayName("로또 구매 내역 출력 테스트")
    @Test
    void printLottoBuyingResultTest() {
        List<List<Integer>> testLottoNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(11, 12, 13, 14, 15, 16),
                Arrays.asList(21, 22, 23, 24, 25, 26));
        for (List<Integer> testLottoNumber : testLottoNumbers) {
            outputView.printNumbers(testLottoNumber);
        }
    }

    @DisplayName("로또 당첨 내역 출력 테스트")
    @Test
    void printLottoWinningResultTest() {
        List<String> testLottoResult = Arrays.asList("5", "4", "3", "1", "2");
        outputView.printLottoWinningResult(testLottoResult);
    }

    @DisplayName("총 수익률 출력 테스트")
    @Test
    void printTotalProfitRateTest() {
        String testProfitRate = "100.1";
        outputView.printTotalProfitRate(testProfitRate);
    }
}
