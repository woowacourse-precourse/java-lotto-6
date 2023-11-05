package lotto.view;

public enum Message {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUM("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUM("보너스 번호를 입력해 주세요."),
    OUTPUT_RESULT("당첨 통계\n---"),
    SAME3("3개 일치 (5,000원) - %d개"),
    SAME4("4개 일치 (50,000원) - %d개"),
    SAME5("5개 일치 (1,500,000원) - %d개"),
    SAME5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SAME6("6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %f%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
