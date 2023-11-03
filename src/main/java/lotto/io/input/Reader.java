package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;

public class Reader implements StdReader {
    @Override
    public String readLine() {
        return Console.readLine().trim();
    }
}
