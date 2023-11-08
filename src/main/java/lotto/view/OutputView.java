package lotto.view;

public class OutputView {
    private static final String ERROR = "[ERROR] ";
    public void purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }


    public void printExceptionMessage(String message) {
        System.out.println(ERROR + message);
    }

    public void lottos(int ticketCount, String lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", ticketCount);
        System.out.println(lottos + "\n");
    }

    public void winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
