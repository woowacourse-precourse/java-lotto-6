package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.PurchaseLotto;
import lotto.domain.SetWinningNumbers;
import lotto.domain.WinningCalculator;
import lotto.domain.Lotto;
import lotto.domain.CalculateProfit;

import lotto.service.GameResultFormat;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    SetWinningNumbers setwinningNumbers = new SetWinningNumbers();
    PurchaseLotto purchaseLotto = new PurchaseLotto();
    OutputView outputView = new OutputView();
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    BonusNumber bonusNumber = new BonusNumber();
    private WinningCalculator winningCalculator;
    private final GameResultFormat gameResultFormat = new GameResultFormat();
    public static List<Integer> winningList = new ArrayList<>();
    public static Lotto lotto;
    public static int countTicket;
    public static int bonusInt;

    public void run(){
        setPurchaseTicket();
        outputView.displayTicketCount(countTicket);
        List<Lotto> lottoList = setLottoNumbers();
        outputView.displayLottoNumbers(lottoList);
        Lotto winningNumber = generateWinningNumbers();
        setBonusNumber();
        calculateProfit(winningNumber, bonusNumber);
    }

    private Lotto generateWinningNumbers(){
        try{
            winningList = setwinningNumbers.setWinningNumbers();
            lotto = new Lotto(winningList);
            return lotto;
        } catch (IllegalArgumentException e){
            outputView.displayErrorMessage(e);
            generateWinningNumbers();
        }
        return lotto;
    }

    private void setPurchaseTicket(){
        try{
            countTicket = purchaseLotto.calculateCount();
        } catch (IllegalArgumentException e){
            outputView.displayErrorMessage(e);
            setPurchaseTicket();
        }
    }

    private List<Lotto> setLottoNumbers(){
        return lottoNumberGenerator.generateLottoList(countTicket);
    }

    private void setBonusNumber(){
        try{
            bonusInt = bonusNumber.inputBonusNumber();
            bonusNumber.checkDuplicated(winningList,bonusInt);
        } catch (IllegalArgumentException e){
            outputView.displayErrorMessage(e);
            setBonusNumber();
        }
    }

    private void checkLottoResults(Lotto winnerNumbers, BonusNumber bonusNumber) {
        this.winningCalculator = new WinningCalculator(lottoNumberGenerator, winnerNumbers, bonusNumber);
        outputView.displayWinningLotto(gameResultFormat.generateWinningStatistics(winningCalculator.calculate()));
    }

    private void computeProfitability() {
        CalculateProfit calculateProfit = new CalculateProfit(winningCalculator.getWinnerCount(), purchaseLotto.getTicketCount());
        outputView.displayRateOfReturn(calculateProfit.calculateRatio());
    }

    private void calculateProfit(Lotto winnerNumbers, BonusNumber bonusNumber) {
        checkLottoResults(winnerNumbers, bonusNumber);
        computeProfitability();
    }

}
