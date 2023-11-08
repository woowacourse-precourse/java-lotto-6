//package lotto.model;
//
//public enum LottoRank {
//    FIRST(6, 0, 2000000000),
//    SECOND(5, 1, 30000000),
//    THIRD(5, 0, 1500000),
//    FOURTH(4, 0, 50000),
//    FIFTH(3, 0, 5000),
//    NONE(0, 0, 0);
//
//    private final int lottoMatchingCount;
//    private final int bonusMatchingCount;
//    private final int prize;
//
//    LottoRank(int lottoMatchingCount, int bonusMatchingCount, int prize) {
//        this.lottoMatchingCount = lottoMatchingCount;
//        this.bonusMatchingCount = bonusMatchingCount;
//        this.prize = prize;
//    }
//
//    public int getLottoCount() {
//        return lottoMatchingCount;
//    }
//
//    public int getBonusCount() {
//        return bonusMatchingCount;
//    }
//
//    public int getPrize() {
//        return prize;
//    }
//}