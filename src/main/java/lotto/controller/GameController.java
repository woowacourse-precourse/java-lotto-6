package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.dto.IssuedLottoTicketsDto;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;
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

    private <T> T executeWithRetry(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                view.displayException(e.getMessage());
            }
        }
    }

    private void purchaseLottoTickets() {
        executeWithRetry(() -> {
            String input = view.getPurchaseAmount();
            int purchaseAmount = PurchaseAmountConverter.convert(input);
            game.purchaseLottoTickets(purchaseAmount);
            return null;
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
        executeWithRetry(() -> {
            String input = view.getWinningNumbers();
            List<Integer> winningNumbers = WinningNumberConverter.convert(input);
            game.setWinningNumbers(winningNumbers);
            return null;
        });
    }

    private void inputBonusNumber() {
        executeWithRetry(() -> {
            String input = view.getBonusNumber();
            int bonusNumber = BonusNumberConverter.convertAndValidate(input);
            game.setBonusNumber(bonusNumber);
            return null;
        });
    }

    private void displayResult() {
        ResultDto resultDto = ResultDto.of(game.getResult());
        view.displayResult(resultDto);
    }

}
