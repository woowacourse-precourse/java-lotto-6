package lotto;

import lotto.request.AskRequest;
import lotto.command.Command;
import lotto.controller.FrontController;
import lotto.request.MultiAskRequest;
import lotto.request.NonAskRequest;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new AskRequest(new FrontController(), Command.INPUT_PURCHASE_AMOUNT).process();
        new NonAskRequest(new FrontController(), Command.BUY_LOTTO).process();
        new NonAskRequest(new FrontController(), Command.OUTPUT_USER_LOTTO).process();
        new MultiAskRequest(new FrontController(), Command.INPUT_BONUS_NUMBER, Command.INPUT_WINNING_NUMBERS).process();
        new NonAskRequest(new FrontController(), Command.OUTPUT_WINNING_RESULT).process();
    }
}
