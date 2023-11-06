package lotto.controller;

import lotto.LottoNumberGenerator.NormalLottoGenerator;
import lotto.model.Game.Game;
import lotto.model.Lotto.Lotto;
import lotto.model.Result.Rank;
import lotto.model.money.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
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
        Game game = new Game(money.amountOfLotto());
        printLottoAmount(game);
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
        return Money.create(inputView.inputMoneyAmount());
    }

    private void printLottoAmount(Game game) {
        outputView.printLottoAmount(game.getAmountOfLotto());
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
        outputView.printEmptyLine();
        game.createWinningLotto(inputView.inputWinningLottoNumbers());
    }

    private void inputUserBonusNumber(Game game) {
        outputView.printEmptyLine();
        game.createBonusNumber(inputView.inputBonusNumber(game.getWinningLotto().getWinningLottoNumbers()));
    }
}
