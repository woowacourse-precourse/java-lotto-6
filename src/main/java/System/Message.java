package System;
public enum Message {
    INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    INPUT_RETRY("다시 입력해주시길 바랍니다."),
    OUTPUT_TOTAL_PURCHASE_AMOUNT("개를 구매했습니다."),
    OUTPUT_WINNING_RESULT("당첨 통계"),
    OUTPUT_SOLID_LINE("---"),
    LINE_BREAK("\n"),
    FIFTH_STATICS("3개 일치 (5,000원) - %d개"),
    FOURTH_STATICS("4개 일치 (50,000원) - %d개"),
    THIRD_STATICS("5개 일치 (1,500,000원) - %d개"),
    SECOND_STATICS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_STATICS("6개 일치 (2,000,000,000원) - %d개"),
    REVENUE_RESULT("총 수익률은 %.1f%%입니다.");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
