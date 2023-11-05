package lotto.game;

import java.util.List;
import java.util.stream.Collectors;

import lotto.view.InputInfo;
import lotto.view.View;

public class GameController {
    private Game game;
    private View view;

    public GameController() {
        game = new Game();
        view = new View();
    }

    public void start() {
        game.purchaseLotto(getPurchaseAmout());
        view.getOutputView().display("");
        view.getOutputView().display(game.getPurchasedLottosInfo());
        view.getOutputView().display("");
        makeWinningLotto();
        view.getOutputView().display("");
        view.getOutputView().display(game.getLottoWinningResult());
    }

    private int getPurchaseAmout() {
        view.getOutputView().displayInputPurcaseAmoutMessage();
        InputInfo userInput = view.getInputView().inputPurchaseAmount();
        while (!userInput.isValidate()) {
            view.getOutputView().displayInputPurcaseAmoutMessage();
            userInput = view.getInputView().inputPurchaseAmount();
        }
        return Integer.valueOf(userInput.getUserInput());
    }

    private void makeWinningLotto() {
        int bonusNumber;
        List<Integer> winningNumber;

        winningNumber = getWinningNumber();
        view.getOutputView().display("");
        bonusNumber = getBonusNumber();
        game.setWinningLotto(winningNumber, bonusNumber);
    }

    private List<Integer> getWinningNumber() {
        view.getOutputView().displayInputWinningNumverMessage();
        InputInfo userInput = view.getInputView().inputWinningNumbers();
        while (!userInput.isValidate()) {
            view.getOutputView().displayInputWinningNumverMessage();
            userInput = view.getInputView().inputWinningNumbers();
        }
        return view.getInputView().splitUserInput(userInput.getUserInput()).stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private int getBonusNumber() {
        view.getOutputView().displayInputBonusNumverMessage();
        InputInfo userInput = view.getInputView().inputBonusNumber();
        while (!userInput.isValidate()) {
            view.getOutputView().displayInputBonusNumverMessage();
            userInput = view.getInputView().inputBonusNumber();
        }
        return Integer.valueOf(userInput.getUserInput());
    }
}
