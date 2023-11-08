package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.service.GameService;
import lotto.validation.Validator;

public class Buyer {
    int buyCount;
    List<Lotto> buyList = new ArrayList<>();
    Validator validator = new Validator();
    DrawMachine drawMachine = new DrawMachine();
    GameService gameService = new GameService();

    public void buyLotto() {
        while (true) {
            String input = InputView.getAmountInput();
            if (validator.isAmountRight(input)) {
                buyCount = Integer.parseInt(input) / 1000;
                break;
            }
        }

        buyList = gameService.makeLottos(buyCount);

        OutputView.printLottos(buyList);
    }

}
