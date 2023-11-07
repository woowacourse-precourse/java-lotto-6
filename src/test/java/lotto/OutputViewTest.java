package lotto;

import lotto.domain.Rank;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class OutputViewTest {
    @Test
    @DisplayName("발행한 로또 수량 및 번호를 출력한다.")
    void printLottoNumbers() {
        OutputView.printMessageOfPurchaseQuantity(8);
        OutputView.printLottoNumbers(new ArrayList<>(Arrays.asList(2, 1, 6, 4, 5, 3)));
    }

    @Test
    @DisplayName("당첨내역을 출력한다.")
    void printWinningStatistics() {
        OutputView.printWinningStatistics(new LinkedHashMap<Rank, Integer>() {{
            put(Rank.FIRST, 1);
            put(Rank.SECOND, 0);
            put(Rank.THIRD, 0);
            put(Rank.FOURTH, 1);
            put(Rank.FIFTH, 2);
        }});
    }

    @Test
    @DisplayName("수익률을 출력한다.")
    void printTotalRateOfReturn() {
        OutputView.printTotalRateOfReturn(62.55);
    }
}
