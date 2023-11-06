package lotto;

import domain.Calculator;
import domain.LottoBundle;
import domain.RandomNumberGenerator;
import view.OutputView;

public class BuyLottoController {
    OutputView outputView = new OutputView();
    Calculator calculator = new Calculator();
    LottoBundle lottoBundle = LottoBundle.getInstance();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void buyLottoLogic(int money) {
        int lottoCount = calculator.calculateMoneyToLottoCount(money);
        // 로또의 수 출력
        outputView.printLottoCount(lottoCount);
        // 로또로 구성된 로또 묶음 생성
        createLottoBundle(lottoCount);
        // 로또 묶음 출력
        outputView.printLottoBundle(lottoBundle.getLottoBundle());
        // 줄바꿈
        outputView.lineBreak();
    }

    private void createLottoBundle(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoBundle.addLotto(randomNumberGenerator.createNewRandomNumber());
        }
    }
}
