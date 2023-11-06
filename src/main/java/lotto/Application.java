package lotto;

import lotto.controller.LottoController;
import lotto.model.Jackpot;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.model.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 로또 구매
        String amount = inputView.inputPurchaseAmount();
        Purchase purchase = lottoController.purcahseLottos(amount);
        int purchaseCount = purchase.getPurchaseCount();
        outputView.printPurchaseCount(purchaseCount);

        // 로또 발급
        List<Lotto> lottos = lottoController.generateLottoTicket(purchaseCount);
        outputView.printLottos(lottos);

        // 당첨 및 보너스 번호 생성
        String winningNumbers = inputView.inputWinningNumbers();
        String bonusNumber = inputView.inputBonusNumber();
        Jackpot jackpot = lottoController.createWinningNumbers(winningNumbers, bonusNumber);

        // 발행된 로또들의 당첨 여부 계산
        Result result = lottoController.createResult(jackpot, lottos, purchase);
        lottoController.calculateWinningRanks(result);
        outputView.printWinningStatistics(result);
        
    }
}
