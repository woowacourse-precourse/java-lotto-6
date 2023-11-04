package lotto.view;

enum Messages{
    PAYMENT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_NUMBER("개를 구매했습니다."),
    WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    CHECK_WINNING_MESSAGE("당첨 통계\n---");
    private final String message;

    Messages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
