package OutputManager;

import lotto.LottoResult;

public enum LottoResultMsgFormat {
    OTHER(LottoResult.OTHER, "꽝"),
    MATCH3(LottoResult.MATCH3, "3개 일치 (5,000원) - "),
    MATCH4(LottoResult.MATCH4, "4개 일치 (50,000원) - "),
    MATCH5(LottoResult.MATCH5, "5개 일치 (1,500,000원) - "),
    MATCH5_AND_BONUS(LottoResult.MATCH5_AND_BONUS, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH6(LottoResult.MATCH6, "6개 일치 (2,000,000,000원) - ");

    private LottoResult result;
    private String msg;

    LottoResultMsgFormat(LottoResult result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public LottoResult getResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }
}
