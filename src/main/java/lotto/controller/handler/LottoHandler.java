package lotto.controller.handler;

import lotto.domain.service.LottoService;
import lotto.ui.input.InputView;
import lotto.ui.output.OutputView;

import static lotto.controller.util.Conversion.makeInt;

public class LottoHandler {

    public void process(String message, LottoService service) {
        String input;
        do {
            OutputView.printMessage(message);
            input = InputView.input();
        } while (hasException(input, service));
    }

    private boolean hasException(String input, LottoService service) {
        try {
            int price = makeInt(input);
            service.buyLotteries(price);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

}
