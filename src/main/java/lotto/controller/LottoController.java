package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.service.LottoService;
import lotto.util.CheckValidation;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public static void run() {
        OutputView.printInputMoneyMsg();
        InputController inputController = new InputController();
        inputController.inputMoney();
        OutputView.printNextLine();
        int amountOfLottoTickets = LottoService.getAmountOfLottoTickets();
        OutputView.printAmountOfLottoTickets(amountOfLottoTickets);
        List<Lotto> lottoTickets = LottoService.makeLottoTickets();
        OutputView.printLottoTickets(lottoTickets);
        OutputView.printNextLine();
        OutputView.printInputWinningNumbersMsg();
        inputController.inputWinningNumbers();
        OutputView.printNextLine();
        OutputView.printInputBonusNumberMsg();
        inputController.inputBonusNumber();
        OutputView.printNextLine();
        List<Statistics> lottoStatistics = LottoService.makeStatistics(LottoService.countCorrectNumbers(lottoTickets));
        OutputView.printStatistics(lottoStatistics);
        double earningRate = LottoService.getEarningRate(lottoStatistics);
        OutputView.printEarningRate(earningRate);
    }
}