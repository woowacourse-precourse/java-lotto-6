package controller;

import domain.*;
import util.ExceptionMessage;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;


public class LottoController {

    private static int amount;
    private static List<Lotto> lotto;
    private static Lotto winningNumbers;
    private static BonusNumber bonusNumber;
    public void playLotto(){
        try {
            purchaseLotto();
            setWinningAndBonus();
            printWinngingStatics();
        } catch(NumberFormatException e){
            System.out.println(ExceptionMessage.NUMBER_FORMAT_EXCEPTION);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void purchaseLotto(){
        PurchaseAmount purchaseAmount = setPurchaseAmount();
        int numberOfLottosPurchased = purchaseAmount.getNumberOfLottoPurchased();
        amount = purchaseAmount.getAmount();
        PurchaseLottos purchaseLottos = setPurchaseLottos(numberOfLottosPurchased);
        lotto = purchaseLottos.getPurchaseLottos();
        printInfo(lotto, numberOfLottosPurchased);
    }

    private void setWinningAndBonus(){
        winningNumbers = setWinningNumbers();
        bonusNumber = setBonusNumber(winningNumbers);
    }

    private Lotto setWinningNumbers(){
        return new Lotto(InputView.enterWinningNumbers());
    }

    private BonusNumber setBonusNumber(Lotto winningNumbers){
        return new BonusNumber(InputView.enterBonusNumber(), winningNumbers);
    }

    private PurchaseAmount setPurchaseAmount(){
        return new PurchaseAmount(InputView.enterAmount());
    }

    private PurchaseLottos setPurchaseLottos(int numberOfLottosPurchased){
        return new PurchaseLottos(numberOfLottosPurchased);
    }

    private void printInfo(List<Lotto> lotto, int numberOfLottosPurchased){
        OutputView.printNumberOfLottosPurchased(numberOfLottosPurchased);
        OutputView.printLottos(lotto);
    }

    private void printWinngingStatics(){
        ProfitCalculator profitCalculator = new ProfitCalculator();
        profitCalculator.calculateProfit(lotto, winningNumbers, bonusNumber.getBonusNumber());
        HashMap<WinningHistory, Integer> winningHistories = profitCalculator.getWinningHistory();
        String rateOfReturn = profitCalculator.calculateRateOfReturn(amount);
        String winningMessage = profitCalculator.getWinningMessages(winningHistories);
        OutputView.printWinningStatisticsHeader();
        OutputView.printWinningMessage(winningMessage, rateOfReturn);
    }
}
