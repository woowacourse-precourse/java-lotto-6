package controller;

import domain.LottoMachine;
import domain.WinningNumbers;
import java.util.List;
import domain.Lotto;
import service.LottoGame;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class Controller {
    private final LottoGame lottoGame = new LottoGame();
    private LottoMachine lottoMachine;

    private void showPurchasedLottoInfo() {
        OutputView.printPurchaseCount(lottoMachine.getSpend());
        OutputView.printLottoNumbers(lottoMachine.getLottoTickets());
    }

    private void setupWinningNumbers() {
        OutputView.printInputWinningNumbers();
        String lottoNumbers = InputView.inputWinningNumbers();
        String[] separatedWinningNumbers = Utils.splitInputByComma(lottoNumbers);
        List<Integer> winningNumbers = Utils.convertToIntegerList(separatedWinningNumbers);

        OutputView.printInputBonusNumber();
        int bonusNumber = InputView.inputBonusNumber();
        new WinningNumbers(winningNumbers, bonusNumber);
    }

    private void setupLottoMachine() {
        OutputView.printInputSpend();
        int spend = InputView.inputSpend();
        int lottoTicketCount = spend / 1000;
        List<Integer> lottoNumbers = Utils.generateLottoNumbers();
        List<Lotto> lottoTickets = lottoGame.generateLottoTickets(lottoTicketCount, lottoNumbers);
        lottoMachine = new LottoMachine(spend, lottoTickets);
    }
}