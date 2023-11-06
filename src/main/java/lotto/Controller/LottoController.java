package lotto.Controller;

import java.util.List;
import lotto.model.LottoPurchaseManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager();

    public LottoController(InputView inputView,OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        purchaseLotto();
        validateLotto();
    }

    private void purchaseLotto() {
        //구매할 로또 개수 받아와서 로또 객체 생성
        outputView.promptForPurchaseAmount();
        int purchaseAmount = inputView.readPurchaseAccount();
        outputView.displayPurchaseAmount(purchaseAmount);


        //생성한 로또 출력
        outputView.displayPurchaseLotto();
    }

    private void validateLotto() {
        //사용자에게 당첨될 로또 번호 받아오기
        outputView.promptForWinningNumbers();
        List<Integer> winningNumbers = inputView.readWinningNumbers();
        outputView.promptForBonusNumbers();
        int bonusNumber = inputView.readBonusNumber();

        //최종 결과 출력
        outputView.displayWinningStatistics();
    }

}
