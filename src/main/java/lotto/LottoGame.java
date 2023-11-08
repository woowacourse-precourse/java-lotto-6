package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.services.Buy;
import lotto.services.LottoStats;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private InputView inputView;
    private OutputView outputView;
    private Buy buyInfo;
    private LottoStats lottoStats;

    public void run() {
        ready();
        playLotto();
    }

    private void ready() {
        inputView = new InputView();
        outputView = new OutputView();
        buyInfo = new Buy(new ArrayList<>());
        lottoStats = new LottoStats();
    }

    private void playLotto() {
        int amount = inputView.inputForAmount();

        int buyCount = buyInfo.createToLotto(amount);
        List<List<Integer>> buyLottoNumbers = buyInfo.getBuyLottoNumbers();

        String buyLotto = outputView.printToBuyLotto(buyLottoNumbers, buyCount);
        System.out.println(buyLotto);

        List<Integer> prizeNumbers = inputView.inputForPrizeNumber();
        int bonusNumber = inputView.inputForBonusNumber();
        inputView.closeToConsole();

        Map<String, Integer> stats = lottoStats
                .calculationOfStats(buyLottoNumbers, prizeNumbers, bonusNumber, amount);

        String prizeDetails = outputView.printToPrizeDetails(stats, lottoStats.getEarningRate());
        System.out.println(prizeDetails);

    }
}
