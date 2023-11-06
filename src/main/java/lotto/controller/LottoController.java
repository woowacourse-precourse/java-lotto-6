package lotto.controller;

import lotto.Money;
import lotto.configuration.InputMessage;
import lotto.configuration.PrintMessage;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private static final Integer ONE_THOUSAND = 1000;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void startLotto() {
        Long money = inputPurchaseAmount();
        buyLotto(money);
    }

    private Long inputPurchaseAmount() {
        InputMessage.INPUT_PURCHASE_AMOUNT.inputMessage();
        Long myMoney = Long.parseLong(InputView.input());
        Money money = new Money(myMoney);
        return money.getMoney();
    }

    private void buyLotto(Long money) {
        PrintMessage.BUY_LOTTO_COUNT.printMessage(money/ONE_THOUSAND);
        for (int i = 0; i < money/ONE_THOUSAND; i++) {
            OutputView.lottoNumbersResult(lottoService.generateRandomLottoNumbers(money/ONE_THOUSAND).get(i));
        }
    }
}
