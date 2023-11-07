package lotto.controller;

import java.util.List;
import lotto.dto.LottoAndBonusDTO;
import lotto.dto.MoneyDTO;
import lotto.dto.WinningStatisticDTO;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.service.CalculateLotteryService;
import lotto.service.OrderLottoService;
import lotto.service.SelectWinningLottoService;
import lotto.utils.Converter;
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
        Integer countOfLotto = orderLottoService.order(money.createDTO());
        OutputView.printLottoCountBought(countOfLotto);

        List<Lotto> entireLotto = orderLottoService.getOrderList();

        for (Lotto lotto : entireLotto) {
            OutputView.printLottoNumbers(lotto);
        }
    }

    private void requestSelectWinningLotto() {
        Lotto lotto = requestLotto();
        Bonus bonus = requestBonus();

        selectWinningLottoService.select(new LottoAndBonusDTO(lotto, bonus));
    }

    private Lotto requestLotto() {
        try {
            String inputNumbers = InputView.getWinningNumbers();
            List<Integer> lottoNumbers = Converter.stringToIntegerList(inputNumbers);

            Lotto lotto = new Lotto(lottoNumbers);

            return lotto;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return requestLotto();
        }
    }

    private Bonus requestBonus() {
        try {
            String inputNumber = InputView.getBonusNumber();
            Integer bonusNumber = Converter.stringToInteger(inputNumber);

            Bonus bonus = new Bonus(bonusNumber);

            return bonus;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return requestBonus();
        }
    }

    private void requestCalculateLottery() {
        WinningStatisticDTO winningStatisticDTO = calculateLotteryService.countMatchesNumber();
        MoneyDTO moneyDTO = calculateLotteryService.calculateReturnRates(money.createDTO(), winningStatisticDTO);

        OutputView.printResultOfLottery(winningStatisticDTO);
        OutputView.printReturnRate(moneyDTO);
    }
}
