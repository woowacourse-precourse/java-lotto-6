package lotto.constant;

public enum Views {
    INPUT_PURCHASE_AMOUT_MESSAGE("구입금액을 입력해 주세요 ."),
    OUTPUT_PURCHASE_AMOUT_MESSAGE("개를 구매했습니다 .");


    private final String message;

    Views(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
