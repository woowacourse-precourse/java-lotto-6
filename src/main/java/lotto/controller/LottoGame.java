package lotto.controller;

import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
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
        startGame();
        afterGame();
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

    private static void startGame() {
        buyLotto();
        makeWinLottoNumbers();
    }

    private static void buyLotto() {
        int gameCount = player.getGameCount();

        playerLottos = LottoMachine.purchaseLotto(gameCount);
        OutputView.printPurchasedResult(playerLottos, gameCount);
    }

    private static void makeWinLottoNumbers() {
        Lotto winLotto = readWinNumber();

        winNumbers = makeWinLottoNumberWithBonus(winLotto);
    }

    private static WinningLottoNumber makeWinLottoNumberWithBonus(Lotto winNumbers) {
        try {
            OutputView.askBonusNumber();
            int bonusNumber = ConvertInput.makeBonusNumberToInt(InputView.readInput());
            return WinningLottoNumber.of(winNumbers, bonusNumber);
        } catch (InputException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return makeWinLottoNumberWithBonus(winNumbers);
        }
    }

    private static Lotto readWinNumber() {
        try {
            OutputView.askLottoWinningNumber();
            List<Integer> winLottoNumbers = ConvertInput.makeLottoNumberToList(InputView.readInput());
            return new Lotto(winLottoNumbers);
        } catch (InputException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return readWinNumber();
        }
    }

    private static void afterGame() {
        GameResult gameResult = GameResult.of(playerLottos, winNumbers);

        OutputView.printLottoResult(
                gameResult.calculateLottoRankResult(),
                gameResult.calculateYield(gameResult.calculateWinningMoney(), player.getPurchaseAmount())
        );
    }
}