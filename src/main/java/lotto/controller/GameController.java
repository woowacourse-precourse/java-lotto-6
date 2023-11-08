package lotto.controller;

import java.util.List;
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

    private void purchaseLottoTickets() {
        try {
            String input = view.getPurchaseAmount();
            int purchaseAmount = PurchaseAmountConverter.convert(input);
            game.purchaseLottoTickets(purchaseAmount);
        } catch (IllegalArgumentException e) {
            view.displayException(e.getMessage());
            purchaseLottoTickets();
        }
    }

    private void displayIssuedLottoTickets() {
        int numberOfLottoIssued = game.getNumberOfLottoIssued();
        List<LottoDto> issuedTickets = game.getIssuedLottoTickets().stream()
                .map(LottoDto::of)
                .toList();
        view.displayIssuedLottoTickets(new IssuedLottoTicketsDto(numberOfLottoIssued, issuedTickets));
    }

    private void inputWinningNumbers() {
        try {
            String input = view.getWinningNumbers();
            List<Integer> winningNumbers = WinningNumberConverter.convert(input);
            game.setWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            view.displayException(e.getMessage());
            inputWinningNumbers();
        }
    }

    private void inputBonusNumber() {
        try {
            String input = view.getBonusNumber();
            int bonusNumber = BonusNumberConverter.convertAndValidate(input);
            game.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            view.displayException(e.getMessage());
            inputBonusNumber();
        }
    }

    private void displayResult() {
        ResultDto resultDto = ResultDto.of(game.getResult());
        view.displayResult(resultDto);
    }

}
