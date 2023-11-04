package lotto.message;

public enum InputGuideMessage {
    PLEASE_ENTER_LOTTO_PAYMENT_MESSAGE("로또 구입 희망 금액을 입력해주세요."),
    PLEASE_ENTER_WINNING_NUMBERS_MESSAGE("당첨 번호 6자리를 ,로 구분하여 입력해주세요. ex) 1,2,3,4,5,6"),
    PLEASE_ENTER_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해주세요.");

    String message;

    InputGuideMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
