package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInputReader implements InputReader{
    @Override
    public String readInput(String message) {
        System.out.println(message);
        return readLine();
    }
}
