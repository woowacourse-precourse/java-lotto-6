package lotto.Controller;

import static lotto.enums.ErrorMessage.NUMBER_FORMAT_ERROR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.LottoRankPolicy;
import lotto.model.LottoResultManager;
import lotto.model.LottoPurchaseManager;
import lotto.util.ProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;

public class LottoController implements Controller {

    private InputView inputView;
    private OutputView outputView;
    private LottoPurchaseManager lottoPurchaseManager;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        purchaseLotto();
        generateLotto();
        getWinningNumber();
        checkLottoResult();
    }

    private void purchaseLotto() {
        outputView.promptForPurchaseAmount();
        int purchaseAmount = inputView.readPurchaseAmount();
        lottoPurchaseManager = new LottoPurchaseManager(purchaseAmount);
    }

    private void generateLotto() {
        lottoPurchaseManager.generateLottos();
        outputView.displayPurchaseAmount(lottoPurchaseManager.getCount());
        outputView.displayPurchaseLotto(lottoPurchaseManager.getLottos());
    }

    private void getWinningNumber() {
        //사용자에게 당첨될 로또 번호와 보너스 번호 받아오기
        List<Integer> winningNumbers = new ArrayList<Integer>();
        int bonusNumber = 0;
        outputView.promptForWinningNumbers();
        winningNumbers = inputView.readWinningNumbers();
        Collections.sort(winningNumbers);
        outputView.promptForBonusNumbers();
        bonusNumber = inputView.readBonusNumber();
    }

    private void checkLottoResult() {
        //TODO 구현
        //필요한 값 계산하기
        LottoResultManager lottoResultManager = new LottoResultManager(
            lottoPurchaseManager.getLottos(), new LottoRankPolicy(winningNumbers, bonusNumber));
        double lottoProfit = ProfitCalculator.calculateProfitPercentage(purchaseAmount,
            lottoResultManager.getWinningAmount());
        outputView.displayResult(lottoResultManager.getLottoResult(), lottoProfit);
    }

}
