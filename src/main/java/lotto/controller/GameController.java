package lotto.controller;

import lotto.dto.LottoDto;
import lotto.model.Game;
import lotto.service.GameService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

import java.util.List;

import static lotto.util.GameConstant.*;

// 사용자로부터 값을 입력받고, 이를 출력하기 위한 클래스
public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final GameService gameService;

    public GameController(OutputView outputView, InputView inputView, GameService gameService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.gameService = gameService;
    }

    public void startGame() {
        int cost = inputView.getCost(CONSTANT_INITIAL_VALUE.getConstant());
        Game game = new Game(cost);

        processGame(game);
    }

    private void processGame(Game game) {
        printLottoQuantity(game);
        printLottoInfo(game);
        printLottoResult(game);
    }

    private void printLottoQuantity(Game game) {
        outputView.printLottoQuantity(game.getLottoQuantity());
    }

    private void printLottoInfo(Game game) {
        gameService.purchaseLotto(game);

        for(LottoDto dto : game.getLottoNumbers()) {
            outputView.printPurchasedLotto(dto.getLottoNumber());
        }
        outputView.printNewLine();
    }

    private void printLottoResult(Game game) {
        List<Integer> winnerNumber = getWinnerNumber();
        int bonusNumber = getBonusNumber(winnerNumber);

        printGameResultAndProfit(game, winnerNumber, bonusNumber);
    }

    private List<Integer> getWinnerNumber() {
        List<Integer> winnerNumber = inputView.getWinnerNumber(CONSTANT_INITIAL_VALUE.getConstant());
        outputView.printNewLine();

        return winnerNumber;
    }

    private int getBonusNumber(List<Integer> winnerNumber) {
        int bonusNumber = inputView.getBonusNumber(CONSTANT_INITIAL_VALUE.getConstant(), winnerNumber);
        outputView.printNewLine();

        return bonusNumber;
    }

    private void printGameResultAndProfit(Game game, List<Integer> winnerNumber, int bonusNumber) {
        gameService.getLottoResult(game, winnerNumber, bonusNumber);
        outputView.printGameResults(game.getResultInfo());
        outputView.printGameProfit(game.getGameProfit());
    }
}
