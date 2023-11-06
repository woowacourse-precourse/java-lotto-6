package lotto.config;

public enum Rank {
    FIFTH("3개 일치 (5,000원)"),
    FOURTH("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD("5개 일치 (1,500,000원)"),
    SECOND("4개 일치 (50,000원)"),
    FIRST("3개 일치 (5,000원)");

    private String desc;

    Rank(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
