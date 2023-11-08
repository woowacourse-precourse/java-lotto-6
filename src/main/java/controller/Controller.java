package controller;

import domain.Buyer;
import domain.Lotto;
import domain.LottoMachine;
import domain.Ranking;
import java.util.List;
import java.util.Map;
import service.LottoGame;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class Controller {
    private final LottoGame lottoGame = new LottoGame();
    private LottoMachine lottoMachine;
    private Buyer buyer;
    private Map<Ranking, Integer> lottoResult;

    public void run() {
        setupLottoGame();
        playLottoGame();
        showLottoGameResult();
    }

    private void setupLottoGame() {
        createLottoMachine();
        showPurchasedLottoInfo();
        createBuyer();
    }

    private void createLottoMachine() {
        try {
            OutputView.printInputSpend();
            int spend = InputView.inputSpend();
            List<Lotto> lottoTickets = lottoGame.generateLottoTickets(spend);
            lottoMachine = new LottoMachine(spend, lottoTickets);
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] 입력값을 올바르게 입력해 주세요.");
            createLottoMachine();
        }
    }

    private void showPurchasedLottoInfo() {
        OutputView.printPurchaseCount(lottoMachine.getSpend());
        OutputView.printLottoNumbers(lottoMachine.getLottoTickets());
    }

    private void createBuyer() {
        try {
            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();
            buyer = new Buyer(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] 입력값을 올바르게 입력해 주세요.");
            createBuyer();
        } catch (IndexOutOfBoundsException error) {
            System.out.println("[ERROR] 입력값이 유효한 범위를 벗어납니다. 다시 입력해주세요.");
            createBuyer();
        }
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

    private void playLottoGame() {
        lottoResult = lottoGame.checkYourLottoNumbers(lottoMachine, buyer);
    }

    private void showLottoGameResult() {
        double earningsRate = lottoGame.calculateEarningsRate(lottoResult, lottoMachine);
        OutputView.printLottoResult(lottoResult);
        OutputView.printEarningsRate(earningsRate);
    }
}
