package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.service.Service;
import lotto.utils.Utils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    private static final int LOTTO_LEAST_AMOUNT = 1_000;

    private final Service service = new Service();
    private Buyer buyer;
    private LottoGame lottoGame;

    public void run() {
        beforeLottoGame();
        initLottoGame();
        showGameResult();
    }

    private void beforeLottoGame() {
        buyer = new Buyer(getInputAmount());
        service.buyAllLotto(buyer);
        showBuyingResult();
    }

    private void initLottoGame() {
        lottoGame = new LottoGame(getInputWinningNumbers(), getInputBonusNumber());
    }

    private void showGameResult() {
        service.checkBuyerLotteries(buyer, lottoGame);
        OutputView.winningStatistics();
        OutputView.showRankResult(buyer.getLottoResult());
        OutputView.showYieldResult(buyer.getYield());
    }

    private int getInputAmount() {
        InputView.inputAmount();
        String userInput = readLine().trim();
        return Utils.stringToInteger(userInput);
    }

    private void showBuyingResult() {
        OutputView.purchaseComplete(buyer.getPurchaseAmount() / LOTTO_LEAST_AMOUNT);
        for (Lotto lotto : buyer.getPurchasedLotteries()) {
            OutputView.lottoNumbers(lotto.getNumbers());
        }
    }

    private List<Integer> getInputWinningNumbers() {
        InputView.inputWinningNumbers();
        return Utils.stringToIntegerList(readLine().trim());
    }

    private int getInputBonusNumber() {
        InputView.inputBonusNumber();
        return Utils.stringToInteger(readLine().trim());
    }
}
