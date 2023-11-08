package lotto.Utils;

public enum Message {

    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_AMOUNT("개를 구매했습니다."),
    ENTER_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    START_RANK("당첨 통계\n" + "---"),
    FIFTH_RANK_MESSAGE("3개 일치 (5,000원) - "),
    FOURTH_RANK_MESSAGE("4개 일치 (50,000원) - "),
    THIRD_RANK_MESSAGE("5개 일치 (1,500,000원) - "),
    SECOND_RANK_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_RANK_MESSAGE("6개 일치 (2,000,000,000원) - ");
    private final String message;

    private Message(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }

}
