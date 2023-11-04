package lotto.request;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.command.Command;
import lotto.controller.FrontController;

public class MultiAskRequest extends Request {
    private final List<Command> prevCommand;

    public MultiAskRequest(FrontController frontController, Command lastCommand, Command... prevCommand) {
        super(frontController, lastCommand);
        this.prevCommand = List.of(prevCommand);
    }

    @Override
    protected List<String> askAndInput() {
        List<String> inputs = new ArrayList<>();

        prevCommand.forEach(command -> {
            System.out.println(command.getMessage());
            inputs.add(Console.readLine());
            addBlank();
        });

        System.out.println(command.getMessage());
        inputs.add(Console.readLine());

        return inputs;
    }

    private void addBlank() {
        System.out.println();
    }
}
