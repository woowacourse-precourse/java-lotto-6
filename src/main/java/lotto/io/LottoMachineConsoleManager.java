package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class LottoMachineConsoleManager {

    private LottoMachineConsoleManager() {
    }

    public static String readLine() {
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }
}
