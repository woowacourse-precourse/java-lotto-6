package lotto.view;

public class OutputView {
    public static final String LOTTO_TICKETS_COUNT_FORMAT = "%d개를 구매했습니다.";

    public static String lottoTicketsCountTemplate(int count) {
        return String.format(LOTTO_TICKETS_COUNT_FORMAT, count);
    }
}
