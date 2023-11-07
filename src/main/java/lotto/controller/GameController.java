package lotto.controller;

import java.util.List;
import lotto.dto.IssuedLottoTicketsDto;
import lotto.dto.LottoDto;
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
        purchaseLottoTickets();
        displayIssuedLottoTickets();
        inputWinningNumbers();
        inputBonusNumber();
        displayResult();
    }

    private void retryUntilValidInput(Runnable userInputTask) {
        boolean validInput = false;
        while (!validInput) {
            try {
                userInputTask.run();
                validInput = true;
            } catch (IllegalArgumentException e) {
                view.displayException(e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void purchaseLottoTickets() {
        retryUntilValidInput(() -> {
            String input = view.getPurchaseAmount();
            int purchaseAmount = PurchaseAmountConverter.convert(input);
            game.purchaseLottoTickets(purchaseAmount);
        });
    }

    private void displayIssuedLottoTickets() {
        int numberOfLottoIssued = game.getNumberOfLottoIssued();
        List<LottoDto> issuedTickets = game.getIssuedLottoTickets().stream()
                .map(LottoDto::of)
                .toList();
        view.displayIssuedLottoTickets(new IssuedLottoTicketsDto(numberOfLottoIssued, issuedTickets));
    }

    private void inputWinningNumbers() {
        retryUntilValidInput(() -> {
            String input = view.getWinningNumbers();
            List<Integer> winningNumbers = WinningNumberConverter.convert(input);
            game.setWinningNumbers(winningNumbers);
        });
    }

    private void inputBonusNumber() {
        retryUntilValidInput(() -> {
            String input = view.getBonusNumber();
            int bonusNumber = BonusNumberConverter.convertAndValidate(input);
            game.setBonusNumber(bonusNumber);
        });
    }

    private void displayResult() {
        //TODO
    }

}
