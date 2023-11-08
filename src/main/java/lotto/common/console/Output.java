package lotto.common.console;

public class Output {
    public static final String WRITE_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.";

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static void writeLottoCount(int count) {
        System.out.println(String.format(WRITE_LOTTO_COUNT_FORMAT, count));
    }
}
