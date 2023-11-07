package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputValidator;
import lotto.model.Lotto;
import lotto.model.Playing;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    static int lottoCnt;
    private static Playing playing = new Playing();

    public static void startGame() {
        OutputView.printPurchaseAmountMessage();
        lottoCnt = InputValidator.checkPurchaseAmountInput(Integer.parseInt(Console.readLine()));
        System.out.println();
        OutputView.printLottoCntMessage(lottoCnt);
    }

    public static void playGame(){
        playing.updateLottos(lottoCnt);
        OutputView.printLottosMessage(playing.lottos);

        OutputView.printWinningNumbersMessage();
        List<Integer> winningNumbers = InputValidator.checkWinningNumbersInput();

        OutputView.printBonusNumberMessage();
        Integer bonus = InputValidator.checkValidBonusNumberInput(winningNumbers);

        playing.compareLottosAndWinningNumbers(winningNumbers, bonus);
    }


}
