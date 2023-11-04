package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;

public interface OutputView {
    void displayPurchasedLottos(List<Lotto> lottos);

    void displayWinningStatistics(WinningStatistics winningStatistics);
}
