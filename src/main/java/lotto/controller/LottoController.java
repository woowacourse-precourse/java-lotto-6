package lotto.controller;

import static lotto.view.ExceptionView.printException;
import static lotto.view.LottoInputView.getPurchaseAmount;
import static lotto.view.LottoOutputView.printPurchaseAmount;

import lotto.model.Money;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() { // 초기화
        this.lottoService = new LottoService();
    }

    /**
     * 로또 기능을 시작한다. 로또 구매, 로또 번호 입력, 로또 당첨 결과
     */
    public void run() {
        buyLotto();
    }

    /**
     * 사용자로부터 구매 금액을 입력받고, 로또를 구매한다.
     */
    private void buyLotto() {
        Money money = getAmount();
        lottoService.buyLotto(money);
    }

    /**
     * 사용자로부터 기준에 맞는 구매할 금액을 입력받는다.
     *
     * @return Money 금액
     */
    private Money getAmount() {
        printPurchaseAmount();

        while (true) {
            try {
                Money coin = new Money(getPurchaseAmount());
                lottoService.validateUnit(coin);

                return coin;
            } catch (IllegalArgumentException e) {
                printException(e);
            }
        }
    }

}
