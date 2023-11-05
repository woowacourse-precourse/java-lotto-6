package lotto.view;

enum PrintMessages {
    REQUEST_PAYMENT("구입금액을 입력해 주세요."),
    PURCHASE_NUMBER("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    CHECK_WINNING_MESSAGE("당첨 통계\n---"),
    MATCH_NUMBERS_MESSAGE("%d개 일치 (5,000원) - %d개"),
    MATCH_BONUS_NUMBER_MESSAGE("%d개 일치, 보너스 볼 일치 (30,000,000원) - %d개");
    private final String message;

    PrintMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
