package lotto.configuration;

public enum PrintMessage {
    BUY_LOTTO_COUNT("개를 구매했습니다.");
//    WINNING_STATISTICS("당첨 통계");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public void printMessage(Long count) {
        System.out.println();
        System.out.println(count.toString() + message);
    }
}
