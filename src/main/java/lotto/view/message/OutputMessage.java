package lotto.view.message;

public class OutputMessage {
    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void newLine() {
        System.out.print(System.lineSeparator());
    }
}
