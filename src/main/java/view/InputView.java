package view;

import util.Scanner.IScanner;

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
            throw new IllegalArgumentException();
        }
    }

}
