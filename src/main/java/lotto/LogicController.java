package lotto;

public class LogicController {
    InputValueValidateController inputValueValidateController = new InputValueValidateController();
    BuyLottoController buyLottoController = new BuyLottoController();
    PrizeDescribeController prizeDescribeController = new PrizeDescribeController();
    EarningRateController earningRateController = new EarningRateController();

    public void startGame() {
        // 구입 금액 입력
        int money = inputValueValidateController.validatePurchaseAmount();
        // 구입 금액으로 로또 구입 및 출력
        buyLottoController.buyLottoLogic(money);
        // 당첨 번호 입력
        inputValueValidateController.validatePrizeNumber();
        // 보너스 번호 입력
        int bonusNumber = inputValueValidateController.validateBonusNumber();
        // 당첨 결과 계산
        prizeDescribeController.calculatePrizeDescribeLogic(bonusNumber);
        // 총수익률 계산
        earningRateController.calculateEarningRateLogic(money);
    }
}
