package lotto.ui;

import lotto.domain.number.Lottos;
import lotto.domain.winning.WinningStatistics;

public interface OutputWriter {
    void writePurchaseAmountInput();

    void writeLottos(Lottos lottos);

    void writeWinningNumbersInput();

    void writeBonusNumberInput();

    void writeWinningStatistics(WinningStatistics winningStatistics);

    void writeError(Exception e);
}
