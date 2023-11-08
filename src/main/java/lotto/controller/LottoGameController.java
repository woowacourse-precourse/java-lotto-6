package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Game;
import lotto.model.LottoGame;
import lotto.view.GameView;
import lotto.view.LottoGameView;

public class LottoGameController implements GameController {
    private final LottoGame game;
    private final LottoGameView gameView;
    private boolean playGame = true;

    public LottoGameController(Game game, GameView gameView) {
        this.game = (LottoGame) game;
        this.gameView = (LottoGameView) gameView;
    }

    @Override
    public void play() {
        while (playGame) {
            List<Integer> winningNumbers;
            gameView.showInputRequiredMessage("purchasePrice");
            game.setLottoPurchaseAmount(validateLottoPurchaseAmount());
            game.createLottoTickets();
            gameView.showProgressOf(game);
            gameView.showInputRequiredMessage("winning-numbers");
            winningNumbers = validateWinningNumbers();
            game.setWinningLotto(winningNumbers);
            gameView.showInputRequiredMessage("bonus-number");
            game.setBonusNumber(validateBonusNumber(winningNumbers));
            game.play();
            gameView.showResultOf(game);

            quitGame();
        }
    }

    @Override
    public void quitGame() {
        playGame = game.continues();
    }

    public int validateLottoPurchaseAmount() {
        int number = 0;
        try {
            number = Integer.parseInt(Console.readLine());
            if (number % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("[ERROR] 잘못된 로또 번호입니다.");
        }
        return number;
    }

    private List<Integer> validateWinningNumbers() {
        List<Integer> numberArray = new ArrayList<>();
        try {
            String[] winningNumbersArray;
            winningNumbersArray = Console.readLine().split(",");
            for (String number : winningNumbersArray) {
                numberArray.add(Integer.parseInt(number));
            }

        } catch (Exception e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            numberArray = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        }
        return numberArray;
    }

    private int validateBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());

            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }

        } catch (Exception e) {
            System.out.println("[ERROR] 잘못된 보너스 번호입니다.");
        }
        return bonusNumber;
    }
}
