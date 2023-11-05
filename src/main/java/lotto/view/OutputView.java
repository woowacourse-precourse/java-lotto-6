package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n";
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public void println() {
        System.out.println();
    }

    public void printError(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }

    public void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void printTicket(long ticket) {
        System.out.printf("%d개를 구매했습니다.\n", ticket);
    }

    public void printLottoList(List<Lotto> wallet) {
        wallet.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

}
