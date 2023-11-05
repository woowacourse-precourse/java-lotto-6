package lotto.controller;

import lotto.domain.Player;
import lotto.util.NumberFactory;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

import java.util.List;

// 사용자로부터 값을 입력받고, 이를 출력하기 위한 클래스
public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberFactory numberFactory;

    public GameController(InputView inputView, OutputView outputView, NumberFactory numberFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberFactory = numberFactory;
    }

    public void startGame() {
        outputView.printCostMessage();
        String cost = inputView.getCost();

        Player player = new Player(cost);
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
    }
}
