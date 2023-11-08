package controller;

import domain.CorrectNumbers;
import domain.PrizeCalculate;
import java.util.ArrayList;
import domain.Judge;
import domain.Lotto;
import domain.LottoService;
import domain.WinningNumber;
import view.InputView;
import view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();
    Judge judge = new Judge();
    WinningNumber winningNumber;
    CorrectNumbers correctNumbers;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    PrizeCalculate prizeCalculate = new PrizeCalculate();
    private int lottoPaper;

    public LottoController() {
        startLotto();
        createWinningNumber();
        matchLotto();
    }

    public void startLotto() {
        outputView.printRequirelottoCost();
        lottoPaper = lottoService.buyLotto();
        outputView.printNewLine();
        outputView.printPublishedLotto(lottoPaper);
        lottoService.getLottoNumber();
    }

    public void createWinningNumber() {
        outputView.printRequireWinningNumber();
        winningNumber = new WinningNumber(inputView.getWinningNumber());
        outputView.printRequireBonusNumber();
        winningNumber.setBonusNumber(inputView.getBonusNumber());
    }

    public void matchLotto() {
        outputView.printWinningStat();
        ArrayList<Lotto> myLotto = lottoService.getMyLottoNumber();
        ArrayList<Integer> winningNumber = this.winningNumber.getWinningNumber();
        int bonusNumber = this.winningNumber.getBonusNumber();
        ArrayList<Integer> rank = judge.matchNumbers(myLotto, winningNumber, bonusNumber);
        correctNumbers = new CorrectNumbers(rank);
        int prize = prizeCalculate.calculate(rank);
        outputView.printMatchResult(correctNumbers, prize, lottoPaper);
    }

}
