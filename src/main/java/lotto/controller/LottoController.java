package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.service.CalculateLotteryService;
import lotto.service.OrderLottoService;
import lotto.service.SelectWinningLottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Money money;
    private final OrderLottoService orderLottoService;
    private final SelectWinningLottoService selectWinningLottoService;
    private final CalculateLotteryService calculateLotteryService;

    public LottoController(OrderLottoService orderLottoService,
                           SelectWinningLottoService selectWinningLottoService,
                           CalculateLotteryService calculateLotteryService) {
        this.orderLottoService = orderLottoService;
        this.selectWinningLottoService = selectWinningLottoService;
        this.calculateLotteryService = calculateLotteryService;
    }

    public void proceed() {
        requestMoney();
        requestOrderLotto();
        requestSelectWinningLotto();
        requestCalculateLottery();
    }

    private void requestMoney() {
        try {
            String inputMoney = InputView.getAmountOfMoney();
            money = new Money(inputMoney);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            requestMoney();
        }
    }

    private void requestOrderLotto() {
        orderLottoService.order(money.createDTO());

        List<Lotto> entireLotto = orderLottoService.getOrderList();

        for (Lotto lotto : entireLotto) {
            OutputView.printLottoNumbers(lotto);
        }
    }
}
