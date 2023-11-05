package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String askAmount() {
        printMessage(Command.ASK_AMOUNT);
        return Console.readLine();
    }

    private void printMessage(Command command) {
        System.out.println(command.prompt());
    }
}
