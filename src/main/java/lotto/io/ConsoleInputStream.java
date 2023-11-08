package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;

public class ConsoleInputStream implements InputStream {

    @Override
    public String inputLine() {
        return Console.readLine();
    }

    @Override
    public int inputInt() throws IllegalArgumentException {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.get());
        }
    }
}