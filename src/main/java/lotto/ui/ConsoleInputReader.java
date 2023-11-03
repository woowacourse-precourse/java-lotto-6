package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.number.Lotto;
import lotto.domain.number.Number;
import lotto.domain.purchase.PurchaseAmount;

public class ConsoleInputReader implements InputReader {
    private static final String INVALID_NUMBER_FORMAT = "올바른 숫자 형식이 아닙니다.";
    private static final String WINNING_NUMBERS_DELIMITER = ",";

    @Override
    public PurchaseAmount readPurchaseAmount() {
        String input = read();
        int value = parseInt(input);
        return new PurchaseAmount(value);
    }

    @Override
    public Lotto readWinningNumbers() {
        String input = read();
        String[] split = input.split(WINNING_NUMBERS_DELIMITER);
        List<Number> numbers = Arrays.stream(split)
                .map(this::parseInt)
                .map(Number::new)
                .toList();
        return Lotto.of(numbers);
    }

    @Override
    public Number readBonusNumber() {
        String input = read();
        int value = parseInt(input);
        return new Number(value);
    }

    private String read() {
        return Console.readLine();
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }
    }

    @Override
    public void close() {
        Console.close();
    }
}
