package lotto.service;

import lotto.domain.Lottos;
import lotto.utils.constant.BuyPrice;
import lotto.utils.view.Input;
import lotto.utils.view.Messages;
import lotto.utils.view.Output;

public class LottoService {
    private final Input input = new Input();
    private final Output output = new Output();
    private Lottos lottos;

    public void setupBuyLotto() {
        BuyPrice buyPrice = setupBuyPrice();
        lottos = setupLottos(buyPrice);
    }

    private BuyPrice setupBuyPrice() {
        try {
            output.printMessage(Messages.SETUP_BUY_PRICE_MESSAGE.getMessage());
            return input.setupBuyPrice();
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
            return setupBuyPrice();
        }
    }

    private Lottos setupLottos(BuyPrice buyPrice) {
        return new Lottos(buyPrice);
    }
}
