package lotto.constant;

public enum UserResponeMessage {
    PURCHASE_MESSAGE("개를 구매했습니다."),
    WINNING_STATISTIC_MESSAGE("당첨 통계");

    private final String message;

    UserResponeMessage(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return message;
    }
}
