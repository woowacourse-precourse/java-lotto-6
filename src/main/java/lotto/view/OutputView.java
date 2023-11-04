package lotto.view;

import lotto.model.Lotto;
import lotto.model.Result;

import java.util.List;

public interface OutputView {
    void printBoughtLotto(List<Lotto> boughtLotto);

    void printWinningStatistics(Result result);

    void printTotalReturn(Double totalReturn);

    void printErrorMessage(Exception exception);
}
