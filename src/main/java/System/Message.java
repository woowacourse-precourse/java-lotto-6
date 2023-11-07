package System;
public enum Message {
    INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_TOTAL_PURCHASE_AMOUNT("개를 구매했습니다."),
    OUTPUT_WINNING_RESULT("당첨 통계"),
    OUTPUT_SOLID_LINE("------");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
