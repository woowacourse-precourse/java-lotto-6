package view;

import lotto.domain.Money;
import util.Scanner.IScanner;

public class InputView {

    private final IScanner scanner;

    public InputView(IScanner scanner) {
        this.scanner = scanner;
    }

    public Money getMoney() {
        String line = scanner.readLine();
        validateNumber(line);
        return new Money(Integer.parseInt(line));
    }

    private void validateNumber(String line) {
        for (char c : line.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

}
