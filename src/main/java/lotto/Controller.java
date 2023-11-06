package lotto;

import domain.Calculator;
import domain.Converter;
import domain.Lotto;
import domain.LottoBundle;
import domain.PrizeNumber;
import domain.RandomNumberGenerator;
import java.util.List;
import view.OutputView;

public class Controller {
    OutputView outputView = new OutputView();
    Converter converter = new Converter();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    Calculator calculator = new Calculator();
    LottoBundle lottoBundle = new LottoBundle();
    InputValueValidateController inputValueValidateController = new InputValueValidateController();
    PrizeNumber prizeNumber = PrizeNumber.getInstance();
    public void startGame() {
        // 구입 금액 입력
        int money = inputValueValidateController.validatePurchaseAmount();
        // 구입 금액으로 살 수 있는 로또의 수 계산
        int lottoCount = converter.convertMoneyToLottoCount(money);
        // 로또의 수 출력
        outputView.printLottoCount(lottoCount);
        // 로또로 구성된 로또 묶음 생성
        createLottoBundle(lottoCount);
        // 로또 묶음 출력
        outputView.printLottoBundle(lottoBundle.getLottoBundle());
        // 줄바꿈
        outputView.lineBreak();
        // 당첨 번호 입력
        inputValueValidateController.validatePrizeNumber();
        // 보너스 번호 입력
        int bonusNumber = inputValueValidateController.validateBonusNumber();
        // 줄바꿈
        outputView.lineBreak();
        // 당첨 통계 계산
        createPrizeDescribe(prizeNumber.getPrizeNumber(), bonusNumber);
        // 당첨 통계 출력
        outputView.printPrizeDescribe(calculator);
        // 총수익률 계산
        String earningRate = calculator.calculateEarningRate(money);
        // 총수익률 출력
        outputView.printEarningRate(earningRate);
    }

    private void createLottoBundle(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoBundle.addLotto(randomNumberGenerator.createNewRandomNumber());
        }
    }

    private void createPrizeDescribe(List<Integer> prizeNumber, int bonusNumber) {
        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            calculator.calculatePrizeDescribe(lotto, prizeNumber, bonusNumber);
        }
    }
}
