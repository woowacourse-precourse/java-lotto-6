package lotto.view;

import lotto.util.Scanner.IScanner;

import java.util.List;
import java.util.stream.Stream;

import static lotto.constant.ExceptionMessage.NOT_NUMBER_MESSAGE;

public class InputView {

    private final IScanner scanner;

    public InputView(IScanner scanner) {
        this.scanner = scanner;
    }

    public int getNumber() {
        String string = scanner.readLine();
        return convertNumber(string);
    }

    private int convertNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        String string = scanner.readLine();
        return convertNumbers(string);
    }

    private List<Integer> convertNumbers(String string) {
        return Stream.of(string.split(","))
                .map(this::convertNumber)
                .toList();
    }

}
