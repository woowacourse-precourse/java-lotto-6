package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.Lottos;
import lotto.domain.Order;
import lotto.domain.WinningInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private static final String WINNING_NUMBERS_DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Order order = getOrderFromInput();
        Lottos lottos = Lottos.createRandomLottos(order.getQuantity());
        outputView.printOrderResult(order.getOrderResultDto(lottos));
        WinningInfo winningInfo = getWinningInfo();
        GameResult gameResult = lottos.getGameResult(winningInfo);
        outputView.printGameResult(gameResult.getGameResultDto(order));
    }

    private Order getOrderFromInput() {
        inputView.printBuyAmountInput();
        int buyAmount = inputView.getNumberInput();
        return Order.create(buyAmount);
    }

    private WinningInfo getWinningInfo() {
        List<Integer> winningNumbers = getWinningNumbersFromInput();
        int bonusNumber = getBonusNumberFromInput();
        return WinningInfo.create(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbersFromInput() {
        inputView.printWinningNumbersInput();
        String userInput = inputView.getUserInput();
        return Arrays.stream(userInput.split(WINNING_NUMBERS_DELIMITER))
                .map(String::trim)
                .map(Integer::valueOf)
                .toList();
    }

    private int getBonusNumberFromInput() {
        inputView.printBonusNumberInput();
        return inputView.getNumberInput();
    }
}
