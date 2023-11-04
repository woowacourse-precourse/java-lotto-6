package lotto.DTO;

public enum SystemMessageDTO {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    OUTPUT_PURCHASE_AMOUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    COMMENT_WINNING_STAT("당첨 통계"),
    HORIZONTAL_RULE("---"),
    FIFTH_STAT("3개 일치 (5,000원) - "),
    FOURTH_STAT("4개 일치 (50,000원) - "),
    THIRD_STAT("5개 일치 (1,500,000원) - "),
    SECOND_STAT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_STAT("6개 일치 (2,000,000,000원) - "),
    TOTAL_STAT("총 수익률은 "),
    POSTPOSITION("입니다."),
    COUNT("개");

    private final String msg;

    SystemMessageDTO(String msg) {
        this.msg = msg;
    }

    public String getSystemMessage(){
        return msg;
    }
}