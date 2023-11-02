package lotto;

public enum LottoResult {
    OTHER(0),
    MATCH3(5000),
    MATCH4(50000),
    MATCH5(1500000),
    MATCH5_AND_BONUS(30000000),
    MATCH6(2000000000);

    private Integer cnt;
    LottoResult(Integer cnt) {
        this.cnt = cnt;
    }

    public Integer getPrize() {
        return cnt;
    }
}
