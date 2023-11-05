package lotto.controller;

import lotto.domain.Player;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

// 사용자로부터 값을 입력받고, 이를 출력하기 위한 클래스
public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.printCostMessage();
        String cost = inputView.getCost();

        Player player = new Player(cost);
        outputView.printPurchaseResult(player.getLottoCount());
    }
}
