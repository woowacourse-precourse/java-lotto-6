package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputValidator;
import lotto.model.Lotto;
import lotto.model.Playing;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    static int inputAmount;
    static int lottoCnt;
    private static Playing playing = new Playing();
    private static List<Integer> winningNumbers = new ArrayList<>();

    public static void startGame() {
        OutputView.printPurchaseAmountMessage();
        inputAmount = InputValidator.checkPurchaseAmountInput();
        lottoCnt = inputAmount / 1000;
        System.out.println();
        OutputView.printLottoCntMessage(lottoCnt);
    }

    public static void playGame(){
        playing.updateLottos(lottoCnt);
        OutputView.printLottosMessage(playing.lottos);

        OutputView.printWinningNumbersMessage();
        winningNumbers = InputValidator.checkWinningNumbersInput();

        OutputView.printBonusNumberMessage();
        Integer bonus = InputValidator.checkValidBonusNumberInput(winningNumbers);

        playing.compareLottosAndWinningNumbers(winningNumbers, bonus);
    }

    public static void endGame(){
        OutputView.printGameResultMessage();
        playing.getWinningStatistics(playing.lottos);
        OutputView.printWinningStatisticsMessage(playing.winningStatistics);

        String rateOfReturn = playing.getRateOfReturn(inputAmount);
        OutputView.printRateOfReturnMessage(rateOfReturn);
    }


}
