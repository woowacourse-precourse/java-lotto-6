package lotto.controller;

import lotto.domain.LottoAnalyzer;
import lotto.domain.LottoVendingMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final LottoVendingMachine lottoVendingMachine;

    public GameController() {
        lottoVendingMachine = new LottoVendingMachine();
    }

    public void play() {
        lottoVendingMachine.purchaseLotto(InputView.inputPurchaseAmount());
        OutputView.printLottoTicketNumber(lottoVendingMachine.getLottoTicketNumber());
        OutputView.printPurchasedLottoTickets(lottoVendingMachine.getLottos());

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lottoVendingMachine.getLottos());
        lottoAnalyzer.addWinningNumbers(InputView.inputWinningNumbers());
        addBonusNumber(lottoAnalyzer);
        lottoAnalyzer.analyzeLotto();
        OutputView.printFinalResult(lottoAnalyzer.getWinningStatistics());
    }

    private static void addBonusNumber(LottoAnalyzer lottoAnalyzer) {
        int bonusNumber = InputView.inputBonusNumber();
        try {
            lottoAnalyzer.addBonusNumber(bonusNumber);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            addBonusNumber(lottoAnalyzer);
        }
    }
}
