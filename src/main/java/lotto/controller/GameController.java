package lotto.controller;

import static lotto.SystemMessage.INPUT_BONUS;
import static lotto.SystemMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.SystemMessage.INPUT_WINNING_LOTTO;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Referee;
import lotto.domain.Win;

public class GameController {
    public void run() {
        LottoController lottoController = new LottoController(readPurchaseAmount());
        lottoController.printLottos();

        Win win = new Win();
        win.setWinningLotto(readWinningLotto());
        win.setBonus(readBonus());

        Referee referee = new Referee();
        referee.compare(lottoController.getLottos(), win.getWinningLotto(), win.getBonus());
    }

    private static int readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    private static String readWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO.getMessage());
        return Console.readLine();
    }

    private static int readBonus() {
        System.out.println(INPUT_BONUS.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
