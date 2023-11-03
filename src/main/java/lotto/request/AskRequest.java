package lotto.request;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.Command;
import lotto.controller.FrontController;

public class AskRequest extends Request {

    public AskRequest(FrontController frontController, Command command) {
        super(frontController, command);
    }

    @Override
    protected String askAndInput() {
        System.out.println(command.getMessage());
        return Console.readLine();
    }
}
