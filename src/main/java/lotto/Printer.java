package lotto;

public class Printer {
    private static final int MONEY_UNIT = 1000;
    private static Printer printer;

    private Printer() {}

    public static Printer getPrinter() {
        if (printer == null) {
            printer = new Printer();
        }
        return printer;
    }

    public void countOfLotto(int won) {
        System.out.println(won/MONEY_UNIT + "개를 구매했습니다.");
    }
}
