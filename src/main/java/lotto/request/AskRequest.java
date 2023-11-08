package lotto.request;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.command.Command;
import lotto.controller.FrontController;

public class AskRequest extends Request {

    public AskRequest(FrontController frontController, Command command) {
        super(frontController, command);
    }

    @Override
    protected List<String> askAndInput() {
        printMessage();
        String input = Console.readLine();
        command.validate(input);

        return List.of(input);
    }

    private void printMessage() {
        System.out.println(command.getMessage());
    }
}
