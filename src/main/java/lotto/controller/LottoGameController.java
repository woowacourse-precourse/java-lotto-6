package lotto.controller;

import static lotto.constants.Common.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.GameService;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final GameService gameService;

    public LottoGameController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.gameService = new GameService();
    }

    private long inputPurchasePrice() {
        try {
            inputView.printInputPricePrompt();
            String rawPrice = Console.readLine();
            InputValidator.validateUserInputPrice(rawPrice);
            return Long.parseLong(rawPrice);
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return inputPurchasePrice();
        }
    }

    private List<Integer> parseRawWinningNumber(String rawInput) {
        List<Integer> parsed = new ArrayList<>();
        for (String rawNumber : rawInput.split(DELIMITER)) {
            parsed.add(Integer.parseInt(rawNumber));
        }
        return parsed;
    }

    private List<Integer> inputWinningNumbers() {
        try {
            inputView.printInputWinningNumbersPrompt();
            String rawWinningNumbers = Console.readLine();
            InputValidator.validateUserInputWinningNumbers(rawWinningNumbers);
            return parseRawWinningNumber(rawWinningNumbers);
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private int inputBonusNumber() {
        try {
            inputView.printInputBonusNumberPrompt();
            String rawBonusNumber = Console.readLine();
            InputValidator.validateUserInputBonusNumber(rawBonusNumber);
            return Integer.parseInt(rawBonusNumber);
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return inputBonusNumber();
        }
    }

    public void process() {
        this.gameService.setPurchaseAmount(inputPurchasePrice());
        this.gameService.purchaseTickets();
        this.resultView.printPurchasedTickets(this.gameService.getPurchasedTickets());
        this.gameService.setWinningTicket(inputWinningNumbers());
        this.gameService.setBonusNumber(inputBonusNumber());
        this.gameService.processGame();
        this.resultView.printResult(GameResult.values(), this.gameService.getRevenue());
    }
}
