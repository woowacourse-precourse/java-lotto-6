package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.WinningNumbers;
import java.util.List;
import service.LottoGame;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class Controller {
    private final LottoGame lottoGame = new LottoGame();
    private LottoMachine lottoMachine;

    public void run() {
        setupLottoGame();
        showPurchasedLottoInfo();
        setupWinningNumbers();
    }

    private void setupLottoGame() {
        createLottoMachine();
    }

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

    private void createLottoMachine() {
        OutputView.printInputSpend();
        int spend = InputView.inputSpend();
        List<Lotto> lottoTickets = lottoGame.generateLottoTickets(spend);
        lottoMachine = new LottoMachine(spend, lottoTickets);
    }
}