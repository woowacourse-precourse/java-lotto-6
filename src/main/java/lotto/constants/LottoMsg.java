package lotto.constants;

public enum LottoMsg {
    LOTTO_BUY_PRICE("구입금액을 입력해 주세요."),
    LOTTO_COMMON_MSG("%s 번호를 입력해 주세요."),
    LOTTO_RESULT("당첨 통계"),
    LOTTO_LATE("총 수익률은 %d입니다.");
    private String msg;

    LottoMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
