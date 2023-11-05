package lotto;

import java.math.BigDecimal;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {
    @Override
    public String readLine() {
        return Console.readLine();
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
