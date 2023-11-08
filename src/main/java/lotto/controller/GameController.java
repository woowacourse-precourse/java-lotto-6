package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.BuyLottos;
import lotto.domain.BuyAmount;
import lotto.domain.Winning;
import lotto.domain.WinningStatisticsCalculator;
import lotto.domain.ExceptionMessage;
import lotto.view.Input;
import lotto.view.Output;

import java.util.HashMap;
import java.util.List;

public class GameController {
    private static int amount;
    private static List<Lotto> lottos;
    private static Lotto winningNumbers;
    private static BonusNumber bonusNumber;

    public void playLottoGame() {
        try {
            buyLotto();
            setWinningNumbers();
            showWinningStatics();
        } catch (NumberFormatException exception) {
            System.out.println(ExceptionMessage.NUMBER_FORMAT_EXCEPTION);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void buyLotto() {
        BuyAmount buyAmount = setBuyAmount();
        int numberOfLottosPurchased = buyAmount.getNumberOfLottos();
        amount = buyAmount.getPayment();

        BuyLottos buyLottos = setBuyLottos(numberOfLottosPurchased);
        lottos = buyLottos.getBuyLottos();

        printBuyInform(numberOfLottosPurchased, lottos);
    }

    private void setWinningNumbers() {
        winningNumbers = setWinningNumber();
        System.out.println();
        bonusNumber = setBonusNumbers(winningNumbers);
        System.out.println();
    }

    private void showWinningStatics() {
        WinningStatisticsCalculator winningStatisticsCalculator = new WinningStatisticsCalculator();
        winningStatisticsCalculator.calculateNumberOfWins(lottos, winningNumbers, bonusNumber.getBonusNumber());

        HashMap<Winning, Integer> winningHistories = winningStatisticsCalculator.getWinning();
        String rateOfReturn = winningStatisticsCalculator.calculateRateOfReturn(amount);

        Output.printStatics(winningHistories);
        Output.printRateOfReturn(rateOfReturn);
    }

    private BuyAmount setBuyAmount() {
        return new BuyAmount(Input.inputPayment());
    }

    private BuyLottos setBuyLottos(int numberOfLottoPurchased) {
        return new BuyLottos(numberOfLottoPurchased);
    }

    private void printBuyInform(int numberOfLottosPurchased, List<Lotto> lottos) {
        Output.printNumberOfLottosPurchased(numberOfLottosPurchased);
        Output.printLottosList(lottos);
    }

    private Lotto setWinningNumber() {
        return new Lotto(Input.inputWinningNumber());
    }

    private BonusNumber setBonusNumbers(Lotto winningNumbers) {
        return new BonusNumber(Input.inputBonusNumber(), winningNumbers);
    }
}