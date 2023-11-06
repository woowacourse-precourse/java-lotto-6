package lotto.controller;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.service.GameService;
import lotto.util.NumberFactory;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

import java.util.List;

// 사용자로부터 값을 입력받고, 이를 출력하기 위한 클래스
public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final NumberFactory numberFactory;
    private final GameService gameService;

    public GameController(OutputView outputView, InputView inputView, NumberFactory numberFactory, GameService gameService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.numberFactory = numberFactory;
        this.gameService = gameService;
    }

    public void startGame() {
        int cost = inputView.getCost();

        Player player = new Player(cost);
        Game game = new Game(cost);
        outputView.printPurchaseResult(player.getLottoCount());

        for(int lotto = 0; lotto < player.getLottoCount(); lotto++) {
            List<Integer> generatedLotto = numberFactory.getNumbers();
            player.buyLotto(generatedLotto);
            outputView.printLotto(generatedLotto);
        }

        List<Integer> winnerNumber = inputView.getWinnerNumber();
        int bonusNumber = inputView.getBonusNumber(winnerNumber);

        for(Lotto lotto : player.getLotto()) {
            int count = gameService.getMatchedLottoNumber(lotto, winnerNumber);
            boolean bonusResult = gameService.getBonusResult(lotto, bonusNumber);

            game.addPrize(count, bonusResult);
        }

        outputView.printGameResult(game);
        outputView.printGameInterestRate(game.getPrize() / cost * 100);
    }
}
