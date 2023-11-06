package lotto.domain;

public enum LottoEnum {
    RANK5TH("3개 일치", 5000),
    RANK4TH("4개 일치", 50000),
    RANK3RD("5개 일치", 1500000),
    RANK2ND("5개 일치, 보너스 볼 일치", 30000000),
    RANK1ST("6개 일치", 2000000000),
    NOTHING("당첨 아님", 0)
    ;
    private String description;
    private int prize;

    LottoEnum(String description, int prize) {
        this.description = description;
        this.prize = prize;
    }

    public String getDescriptionAndPrize() {
        return description + " (" + String.format("%,d원", prize) + ")";
    }

    public int getPrize() {
        return prize;
    }
}
