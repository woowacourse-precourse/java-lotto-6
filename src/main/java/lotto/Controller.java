package lotto;

import domain.Calculator;
import domain.Converter;
import domain.Lotto;
import domain.LottoBundle;
import domain.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Controller {
    public void startGame() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Converter converter = new Converter();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Calculator calculator = new Calculator();
        LottoBundle lottoBundle = new LottoBundle();

        // View
        outputView.printInputPurchaseAmount();
        String purchaseAmount = inputView.inputStr();
        int money = inputView.inputPurchaseAmount(purchaseAmount);
        // model
        int lottoCount = converter.convertMoneyToLottoCount(money);
        // view
        outputView.printLottoCount(lottoCount);
        for (int i = 0; i < converter.convertMoneyToLottoCount(money); i++) {
            lottoBundle.addLotto(randomNumberGenerator.createNewRandomNumber());
        }
        outputView.printLottoBundle(lottoBundle.getLottoBundle());
        outputView.lineBreak();

        outputView.printInputPrizeNumber();
        String prizeNumber = inputView.inputStr();
        inputView.inputPrizeNumber(prizeNumber);
        outputView.printInputBonusNumber();
        String bonusNumber = inputView.inputStr();
        outputView.lineBreak();
        int bonus = inputView.inputBonusNumber(bonusNumber);

        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            calculator.calculatePrizeDescribe(lotto, inputView.getPrizeNumber(), bonus);
        }

        outputView.printPrizeDescribe(calculator);
        outputView.printEarningRate(calculator.calculateEarningRate(money));
    }

}
