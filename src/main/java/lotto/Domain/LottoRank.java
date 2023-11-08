package lotto.Domain;

import lotto.Constant.Constant;

public enum LottoRank {

    RAND_NONE(0, false, 0, Constant.RANK_NONE),
    RANK_FIFTH(3, false, 5_000, Constant.RANK_FIFTH),
    RANK_FOURTH(4, false, 50_000, Constant.RANK_FOURTH),
    RAND_THIRD(5, false, 1_500_000, Constant.RANK_THIRD),
    RANK_SECOND(5, true, 30_000_000, Constant.RANK_SECOND),
    RANK_FIRST(6, false, 2_000_000_000, Constant.RANK_FIRST);

    private final Integer matchCount;
    private final Boolean matchBonus;
    private final Integer price;
    private final String message;

    LottoRank(Integer matchCount, Boolean matchBonus, Integer price, String message) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.price = price;
        this.message = message;
    }

    public static LottoRank getLottoRank(int matchCount, boolean matchBonus) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == matchCount && lottoRank.matchBonus == matchBonus) {
                return lottoRank;
            }
        }
        return RAND_NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
