package lotto.message;

public enum Output {

    RESULT("당첨 통계\n---"),
    ISSUED_LOTTO_COUNT("%d개를 구매했습니다."),
    TOTAL_YIELD("총 수익률은 %.1f%%입니다.");

    private final String message;

    Output(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }

    public void print(int value) {
        System.out.printf(message, value);
        System.out.println();
    }

    public void print(double value) {
        System.out.printf(message, value);
        System.out.println();
    }
}
