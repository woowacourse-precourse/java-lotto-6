package lotto.global.enums;

public enum ViewMessage {
    OUTPUT_LOTTO_SIZE("개를 구매했습니다."),
    INPUT_MONEY_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;

    ViewMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
    @Override
    public String toString(){
        return this.message;
    }
}
