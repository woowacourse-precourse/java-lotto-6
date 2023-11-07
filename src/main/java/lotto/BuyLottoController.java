package lotto;

import model.Calculator;
import model.LottoBundle;
import view.OutputView;

public class BuyLottoController {
    OutputView outputView = new OutputView();
    Calculator calculator = new Calculator();
    LottoBundle lottoBundle = LottoBundle.getInstance();

    public void buyLottoProcess(int money) {
        outputView.lineBreak();
        // 구입 금액으로 살 수 있는 로또의 수 계산
        int lottoCount = calculator.calculateMoneyToLottoCount(money);
        // 로또의 수 출력
        outputView.printLottoCount(lottoCount);
        // 구매한 로또로 구성된 로또 묶음 생성
        lottoBundle.addLotto(lottoCount);
        // 로또 묶음 출력
        outputView.printLottoBundle(lottoBundle.getLottoBundle());
        // 줄바꿈
        outputView.lineBreak();
    }
}
