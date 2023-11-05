package lotto.enums;

public enum LottoStatus {
    FIRST(6,2000000000L),
    SECOND(5,30000000L),
    THIRD(5,1500000L),
    FOURTH(4,50000L),
    FIFTH(3,5000L),
    SIXTH(0,0L);
    private final int collectCount;
    private final Long prize;

    LottoStatus(int collectCount, long prize) {
        this.collectCount = collectCount;
        this.prize = prize;
    }

}
