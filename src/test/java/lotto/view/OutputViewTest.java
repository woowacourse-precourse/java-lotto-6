package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    OutputView outputView = new OutputView();

    Lotteries lotteries;

    @BeforeEach
    void init() {
        lotteries = Lotteries.from(5);
    }

    @Test
    void printLottoNumbers() {
        List<List<Integer>> ex = lotteries.getNumbersOfLotteries();
        outputView.printLottoNumbers(ex);
    }

    @Test
    void printPurchaseAmount() {
        outputView.printPurchaseAmount(3);
    }

    @Test
    void printEarningRate() {
        outputView.printEarningRate(62.5);
    }
}