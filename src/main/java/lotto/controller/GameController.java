package lotto.controller;

import lotto.dto.GameDto;
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
        printLottoQuantity(game.getLottoQuantity());

        List<LottoDto> lottoDtos = gameService.purchaseLotto(game);
        printLottoInfo(lottoDtos);

        List<Integer> winnerNumber = getWinnerNumber();
        int bonusNumber = getBonusNumber(winnerNumber);

        GameDto lottoResult = gameService.getLottoResult(game, winnerNumber, bonusNumber);
        printLottoResult(lottoResult);
    }

    private void printLottoQuantity(int quantity) {
        outputView.printLottoQuantity(quantity);
    }

    private void printLottoInfo(List<LottoDto> lottoDtos) {
        for(LottoDto dto : lottoDtos) {
            outputView.printPurchasedLotto(dto.getLottoNumber());
        }
        outputView.printNewLine();
    }

    private void printLottoResult(GameDto gameDto) {
        outputView.printGameResults(gameDto.gameResults());
        outputView.printGameProfit(gameDto.profit());
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
}
