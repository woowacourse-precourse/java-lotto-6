package lotto;

import lotto.controller.Controller;
import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.RandomLottoStrategy;
import lotto.model.Model;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new Model(new RandomLottoStrategy()), new View());
        controller.run();
    }
}
