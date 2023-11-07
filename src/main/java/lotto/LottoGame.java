package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.ValidateService;
import lotto.view.GameView;

public class LottoGame {

    private ValidateService validateService;
    private GameView gameView;

    private int buyPrice;

    public LottoGame() {
        this.gameView = new GameView();
        this.validateService = new ValidateService();
    }

    public void start() {
        buyLottoInput();
    }

    private void buyLottoInput() {
        boolean correctInputFlag;
        do {
            try {
                String buyPriceInput = Console.readLine();
                buyPrice = validateService.validateBuyLottoInput(buyPriceInput);
                correctInputFlag = true;
            } catch (IllegalArgumentException e) {
                gameView.errorMessageView(e.getMessage());
                correctInputFlag = false;
            }
        } while (!correctInputFlag);
    }
}
