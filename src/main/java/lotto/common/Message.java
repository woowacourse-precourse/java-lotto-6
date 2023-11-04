package lotto.common;

public enum Message {
    PURCHASE("구입금액을 입력해 주세요."),
    COMPLETE_PURCHASE("cond개를 구매했습니다."),
    LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT(String.format("%s%s%s%s%s%s%s",
            "당첨 통계\n---\n",
            "3개 일치 (5,000원) - cond3개",
            "4개 일치 (50,000원) - cond4개",
            "5개 일치 (1,500,000원) - cond5개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - cond_bonus개",
            "3개 일치 (2,000,000,000원) - cond6개",
            "총 수익률은 cond%입니다.")),
    ERROR_LOTTO_NUMBER(String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            Range.START.getValue(), Range.END.getValue())),
    ERROR_PURCHASE_AMOUNT("[ERROR] 구입 금액은 0원 이상이어야 합니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
