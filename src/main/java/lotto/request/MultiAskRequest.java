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

        executePrevCommand(inputs);
        executeLastCommand(inputs);

        return inputs;
    }

    private void executePrevCommand(List<String> inputs) {
        prevCommand.forEach(cmd -> {
            printMessage(cmd);
            addInput(inputs, cmd);
            addBlank();
        });
    }

    private void executeLastCommand(List<String> inputs) {
        printMessage(command);
        addInput(inputs,command);
    }

    private void addInput(List<String> inputs, Command command) {
        String input = Console.readLine();
        command.validate(input);
        inputs.add(input);
    }

    private void printMessage(Command command) {
        System.out.println(command.getMessage());
    }

    private void addBlank() {
        System.out.println();
    }
}
