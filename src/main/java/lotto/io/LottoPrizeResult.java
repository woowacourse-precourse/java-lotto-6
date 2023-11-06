package lotto.io;

public enum LottoPrizeResult {
    //상수의 value가 각 필드라고 생각하면 되는듯
    THREE_MATCH("3개 일치","10만원"),
    FOUR_MATCH("4개 일치","10만원"),
    FIVE_MATCH("5개 일치","10만원"),
    FIVE_MATCH_WITH_BONUS("5개 일치, 보너스 볼 일치","10만원"),
    SIX_MATCH("6개 일치","10만원");

    private final String message;
    private final String message1;

    LottoPrizeResult(String message,String message1){
        this.message = message;
        this.message1 = message1;
    }
    public String getMessage(){
        return message;
    }
    public String getMessage1(){
        return message1;
    }



}
