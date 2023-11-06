package lotto;

import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class OutputViewTest {
    @Test
    @DisplayName("발행한 로또 수량 및 번호를 출력한다.")
    void printLottoNumbers() {
        OutputView.printPurchaseQuantityMessage(8);
        OutputView.printLottoNumbers(new ArrayList<>(Arrays.asList(2, 1, 6, 4, 5, 3)));
    }

    @Test
    @DisplayName("당첨내역을 출력한다.")
    void printWinningStatistics() {
        OutputView.printWinningStatistics(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0, 0)));
    }

    @Test
    @DisplayName("수익률을 출력한다.")
    void printTotalRateOfReturn() {
        OutputView.printTotalRateOfReturn(62.55);
    }
}
