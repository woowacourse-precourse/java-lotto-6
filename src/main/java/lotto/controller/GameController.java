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
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberFactory numberFactory;
    private final GameService gameService;

    public GameController(InputView inputView, OutputView outputView, NumberFactory numberFactory, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberFactory = numberFactory;
        this.gameService = gameService;
    }

    public void startGame() {
        outputView.printCostMessage();
        String cost = inputView.getCost();

        Player player = new Player(cost);
        Game game = new Game(cost);
        outputView.printPurchaseResult(player.getLottoCount());

        for(int lotto = 0; lotto < player.getLottoCount(); lotto++) {
            List<Integer> generatedLotto = numberFactory.getNumbers();
            player.buyLotto(generatedLotto);
            outputView.printLotto(generatedLotto);
        }

        outputView.printWinnerNumberMessage();

        List<String> winnerNumber = inputView.getWinnerNumber();

        outputView.printBonusNumberMessage();

        String bonusNumber = inputView.getBonusNumber();

        List<Integer> list = winnerNumber.stream().map(Integer::parseInt).toList();

        for(Lotto lotto : player.getLotto()) {
            int count = gameService.getMatchedLottoNumber(lotto, list);
            boolean bonusResult = gameService.getBonusResult(lotto, Integer.parseInt(bonusNumber));

            game.addPrize(count, bonusResult);
        }

        outputView.printGameResult(game);
        outputView.printGameInterestRate(game.getPrize() / Integer.parseInt(cost));
    }
}
