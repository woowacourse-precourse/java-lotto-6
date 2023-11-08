package lotto.model;

public enum LottoResult {
    Rank1(2000000000.0,"6개 일치 (2,000,000,000원) - "),
    Rank2(30000000.0,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    Rank3(1500000.0,"5개 일치 (1,500,000원) - "),
    Rank4(50000.0,"4개 일치 (50,000원) - "),
    Rank5(5000.0,"3개 일치 (5,000원) - "),
    ;

    private final double num;
    private final String message;

    public String getMessage() {
        return message;
    }

    public double getNum() {
        return num;
    }

    LottoResult(double num,String str) {
        this.num = num;
        this.message = str;
    }
}
