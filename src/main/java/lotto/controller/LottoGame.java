package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.WinningLottoNumber;
import lotto.exception.InputException;
import lotto.util.ConvertInput;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private static Player player;
    private static List<Lotto> playerLottos;
    private static WinningLottoNumber winNumbers;

    private LottoGame() {
    }

    public static void openStore() {
        beforeGame();
    }

    private static void beforeGame() {
        readPurchaseAmount();
    }

    private static void readPurchaseAmount() {
        try {
            OutputView.askPurchaseAmount();
            int purchaseMoney = ConvertInput.makePlayerMoneyToInt(InputView.readInput());
            player = Player.from(purchaseMoney);
        } catch (InputException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            readPurchaseAmount();
        }
    }
}