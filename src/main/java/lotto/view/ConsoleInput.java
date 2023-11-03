package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInput implements Input {

    @Override
    public String getInput() {
        return readLine();
    }
}
