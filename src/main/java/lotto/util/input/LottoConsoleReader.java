package lotto.util.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.handler.input.Reader;

public class LottoConsoleReader implements Reader<String> {
    @Override
    public String read() {
        return Console.readLine();
    }
}
