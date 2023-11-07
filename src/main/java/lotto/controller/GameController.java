package lotto.controller;

import java.util.List;
import java.util.concurrent.Callable;
import lotto.model.Game;
import lotto.util.converter.BonusNumberConverter;
import lotto.util.converter.PurchaseAmountConverter;
import lotto.util.converter.WinningNumberConverter;
import lotto.view.View;

public class GameController {
    private final View view;
    private final Game game;

    public GameController(View view, Game game) {
        this.view = view;
        this.game = game;
    }

    public void run() {
        // TODO: 게임 로직 작성
        retryUntilValidInput(this::handlePurchaseLottoTickets);
        retryUntilValidInput(this::handleWinningNumbers);
        retryUntilValidInput(this::handleBonusNumber);
    }

    private void retryUntilValidInput(Callable<Boolean> containUserInput) {
        boolean validInput = false;
        while (!validInput) {
            try {
                validInput = containUserInput.call();
            } catch (IllegalArgumentException e) {
                view.displayException(e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean handlePurchaseLottoTickets() {
        int purchaseAmount = inputPurchaseAmount();
        game.purchaseLottoTickets(purchaseAmount);
        return true;
    }

    private int inputPurchaseAmount() {
        String input = view.getPurchaseAmount();
        return PurchaseAmountConverter.convert(input);
    }

    private boolean handleWinningNumbers() {
        List<Integer> winningNumbers = inputWinningNumbers();
        game.setWinningNumbers(winningNumbers);
        return true;
    }

    private List<Integer> inputWinningNumbers() {
        String input = view.getWinningNumbers();
        return WinningNumberConverter.convert(input);
    }

    private boolean handleBonusNumber() {
        int bonusNumber = inputBonusNumber();
        game.setBonusNumber(bonusNumber);
        return true;
    }

    private int inputBonusNumber() {
        String input = view.getBonusNumber();
        return BonusNumberConverter.convertAndValidate(input);
    }
}
