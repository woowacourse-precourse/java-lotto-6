package lotto.controller;

import lotto.model.Money;
import lotto.service.CalculateLotteryService;
import lotto.service.OrderLottoService;
import lotto.service.SelectWinningLottoService;

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
}
