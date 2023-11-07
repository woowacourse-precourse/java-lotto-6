package lotto;

public enum LottoResult {
    OTHER(0, "꽝"),
    MATCH3(5000, "3개 일치 (5,000원) - "),
    MATCH4(50000, "4개 일치 (50,000원) - "),
    MATCH5(1500000, "5개 일치 (1,500,000원) - "),
    MATCH5_AND_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH6(2000000000, "6개 일치 (2,000,000,000원) - ");

    private Integer prize;
    private String msg;

    LottoResult(Integer prize, String msg) {
        this.prize = prize;
        this.msg = msg;
    }

    public Integer getPrize() {
        return prize;
    }

    public String getMsg() {
        return msg;
    }
}
