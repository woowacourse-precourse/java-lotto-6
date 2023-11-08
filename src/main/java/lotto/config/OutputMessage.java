package lotto.config;

public enum OutputMessage {
    OUTPUT_LOTTO_COUNT("%n%d개를 구매했습니다.%n"),
    OUTPUT_LOTTOS_NUMBER("""
                        %n당첨 통계
                        ---
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개
                        """),
    OUTPUT_LOTTO_PROFIT("총 수익률은 %s%%입니다.%n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
