package lotto;

import java.util.List;

public enum LottoRanking {
    FIRST_PRIZE("6개 일치 (2,000,000,000원)", new Amount("2000000000")),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원)", new Amount("30000000")),
    THIRD_PRIZE("5개 일치 (1,500,000원)", new Amount("1500000")),
    FOURTH_PRIZE("4개 일치 (50,000원)", new Amount("50000")),
    FIFTH_PRIZE("3개 일치 (5,000원)", new Amount("5000")),
    DID_NOT_WIN("", new Amount("0"));

    private final String message;
    private final Amount prizeMoney;

    LottoRanking(String message, Amount prizeMoney) {
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRanking getLottoRanking(long matchCount, boolean hasBonusNumber) {
        if (matchCount < 3) {
            return DID_NOT_WIN;
        }
        if (matchCount == 3) {
            return FIFTH_PRIZE;
        }
        if (matchCount == 4) {
            return FOURTH_PRIZE;
        }
        if (matchCount == 5 && !hasBonusNumber) {
            return THIRD_PRIZE;
        }
        if (matchCount == 5) {
            return SECOND_PRIZE;
        }
        return FIRST_PRIZE;
    }

    public static Amount getTotalPrizeMoney(List<LottoRanking> lottoRankings) {
        List<Amount> amounts = lottoRankings.stream()
                .map(lottoRanking -> lottoRanking.prizeMoney)
                .toList();
        return amounts.stream()
                .reduce(Amount::add)
                .orElse(DID_NOT_WIN.prizeMoney);
    }
}
