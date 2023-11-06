package lotto;

import domain.BonusNumber;
import domain.LottoBundle;
import domain.PrizeNumber;
import domain.PurchaseAmount;

public class LogicController {
    InputValueController inputValueController = new InputValueController();
    BuyLottoController buyLottoController = new BuyLottoController();
    PrizeStatisticsController prizeStatisticsController = new PrizeStatisticsController();
    EarningRateController earningRateController = new EarningRateController();
    PurchaseAmount purchaseAmount = PurchaseAmount.getInstance();
    BonusNumber bonusNumber = BonusNumber.getInstance();
    LottoBundle lottoBundle = LottoBundle.getInstance();
    PrizeNumber prizeNumber = PrizeNumber.getInstance();

    public void startGame() {
        // 구입 금액 입력
        inputValueController.inputPurchaseAmount();
        // 구입 금액으로 로또 구입 및 출력
        buyLottoController.buyLottoLogic(purchaseAmount.getPurchaseAmount());
        // 당첨 번호 입력
        inputValueController.inputPrizeNumber();
        // 보너스 번호 입력
        inputValueController.inputBonusNumber();
        // 당첨 결과 계산
        prizeStatisticsController.calculatePrizeDescribeLogic(lottoBundle, prizeNumber.getPrizeNumber(), bonusNumber.getBonusNumber());
        // 총수익률 계산
        earningRateController.calculateEarningRateLogic(purchaseAmount.getPurchaseAmount());
    }
}
