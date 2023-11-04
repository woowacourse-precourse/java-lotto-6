package lotto.common;

public enum Message {
    PURCHASE("구입금액을 입력해 주세요."),
    COMPLETE_PURCHASE("\ncond개를 구매했습니다."),
    LOTTO_NUMBER("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    RESULT(String.format("%s%s%s%s%s%s%s",
            "\n당첨 통계\n---\n",
            "3개 일치 (" + Money.RANK5.getCashToString() + "원) - cond5개\n",
            "4개 일치 (" + Money.RANK4.getCashToString() + "원) - cond4개\n",
            "5개 일치 (" + Money.RANK3.getCashToString() + "원) - cond3개\n",
            "5개 일치, 보너스 볼 일치 (" + Money.RANK2.getCashToString() + "원) - cond2개\n",
            "6개 일치 (" + Money.RANK1.getCashToString() + "원) - cond1개\n",
            "총 수익률은 cond0%입니다.")),
    ERROR_LOTTO_NUMBER(String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자 %d개 입니다.",
            Range.START.getValue(), Range.END.getValue(), Range.SIZE.getValue())),
    ERROR_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1000원 이상, " + Range.MINIMUM.getValue() + "원 단위만 가능합니다."),
    ERROR_BONUS_NUMBER(String.format("[ERROR] 보너스 번호는 로또 번호와 중복되지 않는 %d부터 %d 사이의 숫자입니다.",
            Range.START.getValue(), Range.END.getValue()));

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
