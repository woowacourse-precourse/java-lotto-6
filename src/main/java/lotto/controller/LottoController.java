package lotto.controller;

import static lotto.service.InputService.transformWinningNumber;
import static lotto.service.LottoService.calculateReturnRate;
import static lotto.service.LottoService.calculateWinningStats;
import static lotto.service.LottoService.generateLottoNumberLists;
import static lotto.service.OutputService.calculateLottoQuantity;
import static lotto.view.InputView.setBonusNumber;
import static lotto.view.InputView.setBonusNumberMessage;
import static lotto.view.InputView.setInputMoney;
import static lotto.view.InputView.setStartMessage;
import static lotto.view.InputView.setWinningNumber;
import static lotto.view.InputView.setWinningNumberMessage;
import static lotto.view.OutputView.printLottoNumbers;
import static lotto.view.OutputView.printPurchaseMessage;
import static lotto.view.OutputView.printReturnRateMessage;
import static lotto.view.OutputView.printWinningStats;
import static lotto.view.OutputView.printWinningStatsMessage;

public class LottoController {
    public void start() {
        setStartMessage();
        setInputMoney();
        calculateLottoQuantity();
        printPurchaseMessage();
        generateLottoNumberLists();
        printLottoNumbers();
        setWinningNumberMessage();
        setWinningNumber();
        setBonusNumberMessage();
        setBonusNumber();
        printWinningStatsMessage();
        transformWinningNumber();
        calculateWinningStats();
        printWinningStats();
        calculateReturnRate();
        printReturnRateMessage();
    }
}
