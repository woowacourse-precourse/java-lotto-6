package lotto.View.Constants;

public enum InfoMessage {
    INPUT_MONEY_MESSAGE ("금액을 입력해 주세요."),
    PURCHASE_QUANTITY_MESSAGE ("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS_MESSAGE  ("당첨 번호를 입력해 주세요."),
    INPUT_LUCKY_NUMBER_MESSAGE  ("보너스 번호를 입력해 주세요."),
    WINNING_SUN_UP ("당첨 통계"),
    CUTTING_LINE ("----");
    
    private final String message;
    
    InfoMessage(String message) {
        this.message = message;
    }
    
    public String getMessage(){
        return message;
    }
}
