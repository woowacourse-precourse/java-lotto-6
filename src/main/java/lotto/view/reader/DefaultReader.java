package lotto.view.reader;

import camp.nextstep.edu.missionutils.Console;

public class DefaultReader implements Reader {

    public String readLine() {
        return Console.readLine();
    }
}
