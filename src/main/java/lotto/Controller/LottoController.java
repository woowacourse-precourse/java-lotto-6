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

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private LottoPurchaseManager lottoPurchaseManager;
    int purchaseAmount = 0;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        purchaseLotto();
        validateLotto();
    }

    private void purchaseLotto() {
        //구매할 로또 개수 받아와서 로또 객체 생성
        try {
            outputView.promptForPurchaseAmount();
            purchaseAmount = inputView.readPurchaseAmount();
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_ERROR.getMessage());
            purchaseLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseLotto();
        }

        lottoPurchaseManager = new LottoPurchaseManager(purchaseAmount);
        lottoPurchaseManager.generateLottos();

        //생성한 로또 출력
        outputView.displayPurchaseAmount(lottoPurchaseManager.getCount());
        outputView.displayPurchaseLotto(lottoPurchaseManager.getLottos());
    }

    private void validateLotto() {
        //사용자에게 당첨될 로또 번호와 보너스 번호 받아오기
        List<Integer> winningNumbers = new ArrayList<Integer>();
        int bonusNumber = 0;
        try {
            outputView.promptForWinningNumbers();
            winningNumbers = inputView.readWinningNumbers();
            Collections.sort(winningNumbers);
            outputView.promptForBonusNumbers();
            bonusNumber = inputView.readBonusNumber();
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_ERROR.getMessage());
            validateLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            validateLotto();
        }

        //필요한 값 계산하기
        LottoResultManager lottoResultManager = new LottoResultManager(
            lottoPurchaseManager.getLottos(), new LottoRankPolicy(winningNumbers, bonusNumber));
        double lottoProfit = ProfitCalculator.calculateProfitPercentage(purchaseAmount,
            lottoResultManager.getWinningAmount());

        //최종 결과 출력
        //TODO 미구현
        outputView.displayResult(lottoResultManager.getLottoResult(), lottoProfit);
    }

}
