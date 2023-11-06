package lotto.view;

enum PrintMessages {
    REQUEST_PAYMENT("구입금액을 입력해 주세요."),
    PURCHASE_NUMBER("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    CHECK_WINNING_MESSAGE("당첨 통계\n---"),
    FIRST_PLACE_MESSAGE("6개 일치 (2,000,000,000원) - %d개\n"),
    SECOND_PLACE_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    THIRD_PLACE_MESSAGE("5개 일치 (1,500,000원) - %d개\n"),
    FOURTH_PLACE_MESSAGE("4개 일치 (50,000원) - %d개\n"),
    FIFTH_PLACE_MESSAGE("3개 일치 (5,000원) - %d개\n"),
    TOTAL_YIELD_MESSAGE("총 수익률은 %.1f%%입니다.\n");
    private final String message;

    PrintMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
