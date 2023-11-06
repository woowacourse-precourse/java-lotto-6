package lotto.controller;

import lotto.domain.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

import static lotto.controller.constant.ErrorConst.INPUT_NOT_LONG;
import static lotto.ui.constant.MessageConst.PURCHASE_REQUEST;

public class LottoController {

    private final LottoService service = new LottoService();

    public void purchaseLotteries() {
        OutputView.printMessage(PURCHASE_REQUEST);
        String input = InputView.input();

        long price = makeLong(input);
        service.buyLotteries(price);
    }

    private long makeLong(String price) {
        try {
            return Long.parseLong(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_LONG, e);
        }
    }

}
