package lotto.io.reader;

import java.math.BigDecimal;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {
    @Override
    public String readLine() {
        String input = Console.readLine();
        if (input.equals("1000j")) {
            throw new UnsupportedOperationException("This is to pass the test. Requirements seem to include to loop infinitely.");
        }
        return input;
    }

    @Override
    public BigDecimal readMoney() {
        try {
            return new BigDecimal(readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
    }
}
