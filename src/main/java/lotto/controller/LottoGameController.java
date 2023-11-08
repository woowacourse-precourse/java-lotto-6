package lotto.controller;

import lotto.LottoNumberGenerator.NormalLottoGenerator;
import lotto.model.Game;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    private InputView inputView;
    private OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void game() {
        Money money = inputUserMoneyAmount();
        int amountOfLotto = money.amountOfLotto();
        Game game = new Game(amountOfLotto);
        printLottoAmount(amountOfLotto);
        generateLottoNumber(game);
        printLottoNumber(game);
        inputWinningLottoNumbers(game);
        inputUserBonusNumber(game);
        compareLotto(game);
        printResultLottoGame(money, game);
    }

    private void printResultLottoGame(Money money, Game game) {
        outputView.printEmptyLine();
        outputView.printResultTitle();

        List<Integer> list = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            list.add(rank.getAmount());
        }
        outputView.printLottoResult(list);
        outputView.printProfit(money.getMoney(), game.getTotalPrice());
    }

    private void compareLotto(Game game) {
        List<Integer> comparedWinning = compareWinningLottoNumber(game);
        List<Boolean> comparedBonus = compareBonusLottoNumber(game);

        for (int i = 0; i < game.getAmountOfLotto(); i++) {
            game.checkLottoResult(comparedWinning.get(i), comparedBonus.get(i));
        }
    }

    private List<Boolean> compareBonusLottoNumber(Game game) {
        return game.compareBonusLotto();
    }

    private List<Integer> compareWinningLottoNumber(Game game) {
        return game.compareLotto();
    }

    private Money inputUserMoneyAmount() {
        while (true) {
            try {
                int userInputMoney = Integer.parseInt(inputView.inputMoneyAmount());
                return Money.create(userInputMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottoAmount(int amountOfLotto) {
        outputView.printLottoAmount(amountOfLotto);
    }

    private void generateLottoNumber(Game game) {
        game.generateLottoNumber(new NormalLottoGenerator());
    }

    private void printLottoNumber(Game game) {
        for (Lotto lotto : game.getLottoNumbers()) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private void inputWinningLottoNumbers(Game game) {
        while (true) {
            try {
                outputView.printEmptyLine();
                game.createWinningLotto(inputView.inputWinningLottoNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputUserBonusNumber(Game game) {
        outputView.printEmptyLine();
        game.createBonusNumber(inputView.inputBonusNumber(game.getWinningLotto().getWinningLottoNumbers()));
    }
}
