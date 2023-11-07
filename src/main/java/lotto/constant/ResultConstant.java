package lotto.constant;

public enum ResultConstant {
    BUY_MESSAGE("%.0f개를 구매했습니다."),
    FIFTH_PLACE_MESSAGE("3개 일치 (5,000원) - %.0f개"),
    FOURTH_PLACE_MESSAGE("4개 일치 (50,000원) - %.0f개"),
    THIRD_PLACE_MESSAGE("5개 일치 (1,500,000원) - %.0f개"),
    SECOND_PLACE_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %.0f개"),
    FIRST_PLACE_MESSAGE("6개 일치 (2,000,000,000원) - %.0f개"),
    PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");
    private final String message;

    ResultConstant(String message){
        this.message = message;
    }

    public String getMessage(double value){
        return this.message.formatted(value);
    }
}
