package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class LottoIoManager implements IoManager {

    @Override
    public String read() {
        return Console.readLine();
    }
}
