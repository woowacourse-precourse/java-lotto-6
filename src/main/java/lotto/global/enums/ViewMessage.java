package lotto.global.enums;

public enum ViewMessage {
    OUTPUT_FIRST_PRIZE("6개 일치 (2,000,000,000원) - "),
    OUTPUT_SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    OUTPUT_THIRD_PRIZE("5개 일치 (1,500,000원) - "),
    OUTPUT_FOURTH_PRIZE("4개 일치 (50,000원) - "),
    OUTPUT_FIFTH_PRIZE("3개 일치 (5,000원) - "),
    OUTPUT_WIN_STATS("당첨 통계\n---"),
    OUTPUT_LOTTO_SIZE("개를 구매했습니다."),
    OUTPUT_RATE_OF_RETURN_FRONT("총 수익률은 "),
    OUTPUT_RATE_OF_RETURN_END("%입니다."),
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
