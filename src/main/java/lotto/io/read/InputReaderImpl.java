package lotto.io.read;

import camp.nextstep.edu.missionutils.Console;

public class InputReaderImpl implements InputReader {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
