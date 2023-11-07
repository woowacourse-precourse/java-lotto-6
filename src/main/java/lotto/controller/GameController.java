package lotto.controller;

import lotto.dto.LottoDto;
import lotto.model.Game;
import lotto.service.GameService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

import java.util.List;

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
        int cost = inputView.getCost();

        Game game = new Game(cost);

        outputView.printLottoQuantity(game.getLottoQuantity());
        gameService.purchaseLotto(game);

        printLottoInfo(game);

        List<Integer> winnerNumber = getWinnerNumber();
        int bonusNumber = getBonusNumber(winnerNumber);

        printLottoResult(game, winnerNumber, bonusNumber);
    }

    private void printLottoInfo(Game game) {
        for(LottoDto dto : game.getLottoNumbers()) {
            outputView.printPurchasedLotto(dto.getLottoNumber());
        }
        outputView.printNewLine();
    }

    private List<Integer> getWinnerNumber() {
        List<Integer> winnerNumber = inputView.getWinnerNumber();
        outputView.printNewLine();

        return winnerNumber;
    }

    private int getBonusNumber(List<Integer> winnerNumber) {
        int bonusNumber = inputView.getBonusNumber(winnerNumber);
        outputView.printNewLine();
        return bonusNumber;
    }

    private void printLottoResult(Game game, List<Integer> winnerNumber, int bonusNumber) {
        gameService.getLottoResult(game, winnerNumber, bonusNumber);
        outputView.printGameResults(game.getResultInfo());
        outputView.printGameProfit(game.getGameProfit());
    }
}
