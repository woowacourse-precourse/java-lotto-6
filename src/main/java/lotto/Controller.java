package lotto;

import lotto.domain.Lotto;
import lotto.constants.Rank;
import lotto.domain.WinningLotto;
import lotto.manager.InputManager;
import lotto.manager.LottoManager;
import lotto.utils.OutputUtils;

import java.util.List;
import java.util.Map;

public class Controller {

    InputManager inputManager = new InputManager();
    OutputUtils outputUtils = new OutputUtils();

    LottoManager lottoManager = new LottoManager();

    public void run() {
        int payMoney = getPayMoney();
        displayBuyLottos();
        createWinningLotto();
        showResult(payMoney);
    }

    private int getPayMoney() {
        int payMoney = inputManager.inputPayMoney();
        lottoManager.setBuyLottos(payMoney);
        return payMoney;
    }

    private void displayBuyLottos() {
        List<Lotto> buyLottos = lottoManager.getBuyLottos();
        outputUtils.displayBuyLottos(buyLottos);
    }


    private void createWinningLotto() {
        WinningLotto winningLotto = inputManager.inputWinningLotto();
        lottoManager.setWinningLotto(winningLotto);
    }

    private void showResult(int payMoney) {
        lottoManager.calculateRank();

        Map<Rank, Integer> lottoResults = lottoManager.getLottoResults();
        String profitRate = lottoManager.calculateProfitRate(payMoney);

        outputUtils.displayLottoResult(lottoResults, profitRate);
    }
}
