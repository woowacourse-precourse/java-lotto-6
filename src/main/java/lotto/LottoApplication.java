package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.command.Command;
import lotto.controller.FrontController;
import lotto.request.AskRequest;
import lotto.request.MultiAskRequest;
import lotto.request.NonAskRequest;
import lotto.request.Request;
import lotto.request.RequestExecutor;

public class LottoApplication {
    private static final List<Request> requests = Arrays.asList(
                new AskRequest(new FrontController(), Command.INPUT_PURCHASE_AMOUNT),
                new NonAskRequest(new FrontController(), Command.BUY_LOTTO),
                new NonAskRequest(new FrontController(), Command.OUTPUT_USER_LOTTO),
                new MultiAskRequest(new FrontController(), Command.INPUT_BONUS_NUMBER, Command.INPUT_WINNING_NUMBERS),
                new NonAskRequest(new FrontController(), Command.OUTPUT_WINNING_RESULT)
            );
    public static void run() {
        new RequestExecutor(requests).execute();
    }
}
