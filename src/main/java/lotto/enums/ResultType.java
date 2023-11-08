package lotto.enums;

public enum ResultType {
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    THIRD("5개 일치 (1,500,000원)", 1_500_000),
    FOURTH("4개 일치 (50,000원)", 50_000),
    FIFTH("3개 일치 (5,000원)", 5_000);

    private String msg;
    private int prize;

    ResultType(String msg, int prize){
        this.msg = msg;
        this.prize = prize;
    }

    public String getMsg() {
        return msg;
    }

    public int getPrize() {
        return prize;
    }

}
