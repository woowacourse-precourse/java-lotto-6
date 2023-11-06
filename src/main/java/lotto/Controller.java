package lotto;

import domain.Calculator;
import domain.Converter;
import domain.Lotto;
import domain.LottoBundle;
import domain.RandomNumberGenerator;
import java.util.List;
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

        // 구매 금액을 입력받고 가져옴
        int money = getMoney(inputView, outputView);
        // 구매 금액으로 살 수 있는 로또의 수를 구함
        int lottoCount = getLottoCount(outputView, converter, money);
        // 로또를 구매함
        buyLottos(outputView, randomNumberGenerator, lottoBundle, lottoCount);
        // 당첨 번호 입력
        List<Integer> prizeNumber = getPrizeNumber(inputView, outputView);
        int bonusNumber = getBonusNumber(inputView, outputView);
        calculatePrize(outputView, calculator, lottoBundle, prizeNumber, bonusNumber);
        calculateEarning(outputView, calculator, money);
    }

    private static void calculateEarning(OutputView outputView, Calculator calculator, int money) {
        String earningRate = calculator.calculateEarningRate(money);
        outputView.printEarningRate(earningRate);
    }

    private static void calculatePrize(OutputView outputView, Calculator calculator, LottoBundle lottoBundle,
                                  List<Integer> prizeNumber, int bonusNumber) {
        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            calculator.calculatePrizeDescribe(lotto, prizeNumber, bonusNumber);
        }

        outputView.printPrizeDescribe(calculator);
    }

    private static int getLottoCount(OutputView outputView, Converter converter, int money) {
        int lottoCount = converter.convertMoneyToLottoCount(money);
        outputView.printLottoCount(lottoCount);
        return lottoCount;
    }

    private static void buyLottos(OutputView outputView, RandomNumberGenerator randomNumberGenerator,
                                  LottoBundle lottoBundle, int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoBundle.addLotto(randomNumberGenerator.createNewRandomNumber());
        }
        // 구매한 로또를 출력함
        outputView.printLottoBundle(lottoBundle.getLottoBundle());
        outputView.lineBreak();
    }

    private static int getBonusNumber(InputView inputView, OutputView outputView) {
        // outputView.printInputBonusNumber();
        // String bonusNumber = inputView.inputStr();

        int bonus = inputView.inputBonusNumber();
        outputView.lineBreak();
        return bonus;
    }

    private static List<Integer> getPrizeNumber(InputView inputView, OutputView outputView) {
        // outputView.printInputPrizeNumber();
        // String prizeNumber = inputView.inputStr();
        inputView.inputPrizeNumber();
        List<Integer> prizeNum = inputView.getPrizeNumber();
        return prizeNum;
    }

    private static int getMoney(InputView inputView, OutputView outputView) {
        // outputView.printInputPurchaseAmount();
        // String purchaseAmount = inputView.inputStr();
        int money = inputView.inputPurchaseAmount();
        return money;
    }

}
