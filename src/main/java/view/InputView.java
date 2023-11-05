package view;

import util.Scanner.IScanner;

public class InputView {

    private final IScanner scanner;

    public InputView(IScanner scanner) {
        this.scanner = scanner;
    }

    public int getNumber() {
        String string = scanner.readLine();
        validateNumber(string);
        return Integer.parseInt(string);
    }

    private void validateNumber(String line) {
        for (char c : line.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

}
