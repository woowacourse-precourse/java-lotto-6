package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.MultiplePureNumbers;
import lotto.common.PureNumber;

public class UserInputReader {

    public static PureNumber readPureNumber() throws IllegalArgumentException {
        return PureNumber.wrap(Console.readLine());
    }

    public static MultiplePureNumbers readMultiplePureNumbers() throws IllegalArgumentException {
        return MultiplePureNumbers.wrap(Console.readLine());
    }

    public static void close() {
        Console.close();
    }
}
