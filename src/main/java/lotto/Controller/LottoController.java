package lotto.Controller;

import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;
import lotto.model.LottoResultPolicy;
import lotto.model.LottoResultManager;
import lotto.model.LottoPurchaseManager;
import lotto.util.ProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController implements Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private LottoPurchaseManager lottoPurchaseManager;
    private LottoResultManager lottoResultManager;
    private LottoResultPolicy lottoResultPolicy = new LottoResultPolicy();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        purchaseLotto();
        generateLotto();
        readWinningNumber();
        readBonusNumber();
        checkLottoResult();
    }

    private void purchaseLotto() {
        try {
            outputView.promptForPurchaseAmount();
            int purchaseAmount = inputView.readPurchaseAmount();
            lottoPurchaseManager = new LottoPurchaseManager(purchaseAmount);
        } catch (NumberFormatException e) {
            outputView.displayNumberFormatError(e);
            purchaseLotto();
        } catch (IllegalArgumentException e) {
            outputView.displayArgumentError(e);
            purchaseLotto();
        }
    }

    private void generateLotto() {
        lottoPurchaseManager.generateLottos();
        outputView.displayPurchaseAmount(lottoPurchaseManager.getPurchaseCount());
        outputView.displayPurchaseLotto(lottoPurchaseManager.getLottos());
    }

    private void readWinningNumber() {
        try {
            outputView.promptForWinningNumbers();
            List<Integer> winningNumbers = inputView.readWinningNumbers();
            lottoResultPolicy.setWinningNumbers(winningNumbers);
        } catch (NumberFormatException e) {
            outputView.displayNumberFormatError(e);
            readWinningNumber();
        } catch (IllegalArgumentException e) {
            outputView.displayArgumentError(e);
            readWinningNumber();
        }
    }

    private void readBonusNumber() {
        try {
            outputView.promptForBonusNumbers();
            int bonusNumber = inputView.readBonusNumber();
            lottoResultPolicy.setBonusNumber(bonusNumber);
        } catch (NumberFormatException e) {
            outputView.displayNumberFormatError(e);
            readBonusNumber();
        } catch (IllegalArgumentException e) {
            outputView.displayArgumentError(e);
            readBonusNumber();
        }
    }

    private void checkLottoResult() {
        lottoResultManager = new LottoResultManager(
            lottoPurchaseManager.getLottos(), lottoResultPolicy);
        Map<LottoRank, Integer> lottoResults = lottoResultManager.getLottoResults();
        double lottoProfit = ProfitCalculator.calculateProfitPercentage(
            lottoPurchaseManager.getPurchaseAmount(),
            lottoResultManager.getWinningAmount());
        outputView.displayResult(lottoResults, lottoProfit);
    }

}
