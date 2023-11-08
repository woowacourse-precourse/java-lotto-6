package lotto.constants;

public enum ProgramMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_COUNT_OF_LOTTO_ISSUED("개를 구매했습니다."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    WINNING_STATISTICS_LINE("---"),
    PRINT_FORM_5TH_PLACE("3개 일치 (5,000원) - "),
    PRINT_FORM_4TH_PLACE("4개 일치 (50,000원) - "),
    PRINT_FORM_3RD_PLACE("5개 일치 (1,500,000원) - "),
    PRINT_FORM_2ND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRINT_FORM_1ST_PLACE("6개 일치 (2,000,000,000원) - ");

    private final String message;

    ProgramMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
