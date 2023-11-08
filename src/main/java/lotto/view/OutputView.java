package lotto.view;

public class OutputView {
    private static final String ERROR = "[ERROR] ";
    public void purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printExceptionMessage(String message) {
        System.out.println(ERROR + message);
    }
}
