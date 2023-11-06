package lotto.enums;

public enum InputGuideMessage {
    PLEASE_ENTER_LOTTO_PAYMENT_MESSAGE("로또 구입 희망 금액을 입력해주세요."),
    PLEASE_ENTER_WINNING_NUMBERS_MESSAGE("당첨 번호 6자리를 ,로 구분하여 입력해주세요. ex) 1,2,3,4,5,6"),
    PLEASE_ENTER_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해주세요."),
    INFORM_PURCHASED_LOTTOS_NUMBERS_MESSAGE("%s개를 구매했습니다.\n"),
    INFORM_WINNING_STATICS_MESSAGE("당첨 통계\n---"),
    INFORM_BONUS_NUMBER_CORRECT_MESSAGE(", 보너스 볼 일치"),
    INFORM_RANK_AND_WINNING_COUNT_MESSAGE("%d개 일치%s (%s원) - %d개\n"),
    INFORM_TOTAL_RATE_OF_RETURN("총 수익률은 %s%%입니다.%n");


    String message;

    InputGuideMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
