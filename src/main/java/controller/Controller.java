package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.Buyer;
import java.util.List;
import service.LottoGame;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class Controller {
    private final LottoGame lottoGame = new LottoGame();
    private LottoMachine lottoMachine;
    private Buyer buyer;

    public void run() {
        setupLottoGame();
    }

    private void setupLottoGame() {
        createLottoMachine();
        showPurchasedLottoInfo();
        createBuyer();
    }

    private void createLottoMachine() {
        OutputView.printInputSpend();
        int spend = InputView.inputSpend();
        List<Lotto> lottoTickets = lottoGame.generateLottoTickets(spend);
        lottoMachine = new LottoMachine(spend, lottoTickets);
    }

    private void showPurchasedLottoInfo() {
        OutputView.printPurchaseCount(lottoMachine.getSpend());
        OutputView.printLottoNumbers(lottoMachine.getLottoTickets());
    }

    private void createBuyer() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        buyer = new Buyer(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        OutputView.printInputWinningNumbers();
        String lottoNumbers = InputView.inputWinningNumbers();
        String[] separatedLottoNumbers = Utils.splitInputByComma(lottoNumbers);
        List<Integer> winningNumbers = Utils.convertToIntegerList(separatedLottoNumbers);
        return winningNumbers;
    }

    private int getBonusNumber() {
        OutputView.printInputBonusNumber();
        int bonusNumber = InputView.inputBonusNumber();
        return bonusNumber;
    }
}
