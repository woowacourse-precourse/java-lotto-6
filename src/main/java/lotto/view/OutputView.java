package lotto.view;

import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.Revenue;

import java.util.List;

public interface OutputView {
    void printBoughtLotto(List<Lotto> boughtLotto);

    void printWinningStatistics(Result result);

    void printTotalReturn(Revenue revenue);

    void printErrorMessage(Exception exception);
}
