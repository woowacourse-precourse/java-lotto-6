package lotto.utility.enums;

public enum Messages {
    INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_COUNT_MESSAGE("개를 구매했습니다."),
    INPUT_LOTTO_WINNING_NUUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private String message;

    Messages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
