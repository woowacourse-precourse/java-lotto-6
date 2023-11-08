package view;

import domain.Lotto;

public class OutputView {
    private static final String PAYMENT_MESSAGE = "%d개를 구매했습니다.";

    public static void printNumberOfLottoTickets(long payment) {
        long lottoTickets = Lotto.countLottoTickets(payment);
        System.out.println(String.format(PAYMENT_MESSAGE, lottoTickets));
    }

    public static void printLottoTickets(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
