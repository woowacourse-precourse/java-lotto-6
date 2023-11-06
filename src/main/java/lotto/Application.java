package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.GameController;
import lotto.domain.lotto.NumberGenerator;
import lotto.domain.lotto.Profit;
import lotto.domain.lotto.WinningNumbers;
import lotto.global.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            GameController gameController = new GameController(new Profit(), new NumberGenerator(), new WinningNumbers());
            gameController.play();
        } catch (Exception e) {
            OutputView.printMessageLine(e.getMessage());
        }

    }
}
