package lotto;

import lotto.domain.LottoPurchaseManager;
import lotto.domain.LottoWinningManager;
import lotto.domain.Prize;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.ui.LottoPurchaseConsoleUI;
import lotto.ui.LottoWinningConsoleUI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoPurchaseManager purchaseManager = new LottoPurchaseManager();
        LottoPurchaseConsoleUI purchaseConsole = new LottoPurchaseConsoleUI(purchaseManager);

        int numOfLottos = purchaseConsole.startPurchaseProcess();

        List<Lotto> lottos = purchaseConsole.startPublishProcess(numOfLottos);

        LottoWinningManager winningManager = new LottoWinningManager();
        LottoWinningConsoleUI winningConsole = new LottoWinningConsoleUI(winningManager);

        winningConsole.startDetermineWinningProcess();

        winningConsole.startSettleProcess(lottos);

    }
}
