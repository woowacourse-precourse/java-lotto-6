package lotto.constant;

public enum ResultConstant {
    BUY_MESSAGE("%d개를 구매했습니다."),
    FIFTH_PLACE_MESSAGE("3개 일치 (5,000원) - %d개"),
    FOURTH_PLACE_MESSAGE("3개 일치 (50,000원) - %d개"),
    THIRD_PLACE_MESSAGE("3개 일치 (1,500,000원) - %d개"),
    SECOND_PLACE_MESSAGE("3개 일치 (30,000,000원) - %d개"),
    FIRST_PLACE_MESSAGE("6개 일치 (2,000,000,000원) - %d개");

    private final String message;

    ResultConstant(String message){
        this.message = message;
    }

    public String getMessage(int value){
        return this.message.formatted(value);
    }
}
