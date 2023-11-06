package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputStream implements InputStream {

    @Override
    public String inputLine() {
        return Console.readLine();
    }

    @Override
    public int inputInt() {
        return Integer.parseInt(Console.readLine());
    }
}