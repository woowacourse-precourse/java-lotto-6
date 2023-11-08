package lotto;

import java.util.List;
import lotto.command.Command;
import lotto.controller.FrontController;
import lotto.controller.config.ControllerConfig;
import lotto.request.AskRequest;
import lotto.request.MultiAskRequest;
import lotto.request.NonAskRequest;
import lotto.request.Request;
import lotto.request.RequestExecutor;

public class LottoApplication {
    private static final FrontController frontController = new FrontController(new ControllerConfig());
    private static final List<Request> requests = List.of(
                new AskRequest(frontController, Command.INPUT_PURCHASE_AMOUNT),
                new NonAskRequest(frontController, Command.BUY_LOTTO),
                new NonAskRequest(frontController, Command.OUTPUT_USER_LOTTO),
                new MultiAskRequest(frontController, Command.INPUT_BONUS_NUMBER, Command.INPUT_WINNING_NUMBERS),
                new NonAskRequest(frontController, Command.OUTPUT_WINNING_RESULT)
            );
    public static void run() {
        new RequestExecutor(requests).execute();
    }
}
