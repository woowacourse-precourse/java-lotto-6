package lotto.controller;

import static lotto.view.View.printMessage;

import java.util.List;
import lotto.constant.Message;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoStore;

import lotto.model.WinningCalculator;
import lotto.validator.ValidateObject;
import lotto.view.View;

public class LottoController {
    private final LottoStore lottoStore;
    private final WinningCalculator winnings;

    public LottoController() {
        this.lottoStore = new LottoStore();
        winnings = new WinningCalculator();
    }

    public void run() {
        Customer customer = buyLottoAndPrintFlow();

        printMessage(customer.getLottoCount() + Message.PURCHASED_LOTTO_COUNT_MESSAGE.getMessage());
        customer.showLottos();

        Lotto winningLotto = InputController.inputWinningNumber();
        int bonusNumber = inputBonusNumberFlow(winningLotto);

        printMessage(Message.RESULT_MESSAGE.getMessage());
        View.seperateLine();

        List<Integer> lottoRank = lottoStore.rankLottos(customer.getLottos(), winningLotto, bonusNumber);

        winnings.setTotalWinningMoney(lottoRank);

        View.printLottoRank(lottoRank);
        View.printMessage(
                Message.RATE_OF_RETURN_PREFIX.getMessage()
                        + winnings.calculateRateOfReturn().toPlainString()
                        + Message.RATE_OF_RETURN_SUFFIX.getMessage());
    }

    private Customer buyLottoAndPrintFlow() {
        Customer customer = InputController.inputMoney();
        this.winnings.setSales(customer.getLottoCount());
        return customer;
    }

    private int inputBonusNumberFlow(Lotto winningLotto) {
        return InputController.inputBonusNumber(winningLotto);
    }
}
