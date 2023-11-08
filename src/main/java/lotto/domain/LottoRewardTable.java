package lotto.domain;


import java.util.Objects;

public enum LottoRewardTable {

    FIFTH(LottoMatchingTable.FIFTH, "3개 일치", 5_000),
    FOURTH(LottoMatchingTable.FOURTH, "4개 일치", 50_000),
    THIRD(LottoMatchingTable.THIRD, "5개 일치", 1_500_000),
    SECOND(LottoMatchingTable.SECOND, "5개 일치, 보너스 볼 일치", 30_000_000),
    FIRST(LottoMatchingTable.FIRST, "6개 일치", 2_000_000_000),
    ;
    private final LottoMatchingTable lottoMatchingTable;
    private final String message;
    private final int reward;

    LottoRewardTable(LottoMatchingTable lottoMatchingTable, String message, int reward) {
        this.lottoMatchingTable = lottoMatchingTable;
        this.message = message;
        this.reward = reward;
    }

    public String getMessage() {
        return String.format("%s (%,d원)", message, reward);
    }

    public int getReward() {
        return reward;
    }

    public boolean hasSameRank(LottoMatchingTable lottoMatchingTable) {
        return Objects.equals(this.lottoMatchingTable, lottoMatchingTable);
    }

}
