package lotto;

import java.util.List;
import model.InputValueValidation;
import view.InputView;

public class ProgramFlowController {
    InputView inputView = new InputView();
    InputValueValidation inputValueValidation = new InputValueValidation();
    InputValueController inputValueController = new InputValueController(inputView, inputValueValidation);
    BuyLottoController buyLottoController = new BuyLottoController();
    PrizeStatisticsController prizeStatisticsController = new PrizeStatisticsController();
    EarningRateController earningRateController = new EarningRateController();

    public void startGame() {
        int purchaseAmount;
        List<Integer> prizeNumber;
        int bonusNumber;

        // 구입 금액 입력
        purchaseAmount = inputValueController.inputPurchaseAmount();
        // 구입 금액으로 로또 구입 및 출력
        buyLottoController.buyLottoProcess(purchaseAmount);
        // 당첨 번호 입력
        prizeNumber = inputValueController.inputPrizeNumber();
        // 보너스 번호 입력
        bonusNumber = inputValueController.inputBonusNumber(prizeNumber);
        // 당첨 결과 계산
        prizeStatisticsController.calculatePrizeStatisticsProcess(prizeNumber, bonusNumber);
        // 총수익률 계산
        earningRateController.calculateEarningRateProcess(purchaseAmount);
    }
}
