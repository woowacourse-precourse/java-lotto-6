package lotto.global.constant;

import java.util.Arrays;

import static lotto.global.constant.BonusNumberMatch.*;
import static lotto.global.constant.NumberDefinition.*;
import static lotto.global.constant.exception.ExceptionMessage.ILLEGAL_MATCH_COUNT;

public enum LottoRank {
    OUT_OF_RANK("순위 밖",0, 0,NOT_MATTER),
    FIFTH_PLACE("3개 일치 (5,000원)", 5_000, 3, NOT_MATTER),
    FOURTH_PLACE("4개 일치 (50,000원)", 50_000, 4, NOT_MATTER),
    THIRD_PLACE("5개 일치 (1,500,000원)", 1_500_000, 5, NOT_MATCH),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000, 5, MATCH),
    FIRST_PLACE("6개 일치 (2,000,000,000원)", 2_000_000_000, 6, NOT_MATTER);

    private final String message;
    private final int price;
    private final int matchCount;
    private final BonusNumberMatch bonusNumberMatch;

    LottoRank(String message, int price, int matchCount, BonusNumberMatch bonusNumberMatch) {
        this.message = message;
        this.price = price;
        this.matchCount = matchCount;
        this.bonusNumberMatch = bonusNumberMatch;
    }

    public static LottoRank getRank(int matchCount, BonusNumberMatch bonusNumberMatch) {
        if(matchCount < 0 || matchCount > LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ILLEGAL_MATCH_COUNT.getMessage());
        }

        if(matchCount < MINIMUM_MATCH.getNumber()) {
            return OUT_OF_RANK;
        }

        return Arrays.stream(LottoRank.values())
                .filter(lotto -> lotto.matchCount == matchCount)
                .filter(lottoRank -> {
                    if(lottoRank.matchCount == BONUS_NUMBER_MATCH_CRITERIA.getNumber()) {
                        return lottoRank.bonusNumberMatch == bonusNumberMatch;
                    }
                    return true;
                }).findFirst()
                .get();

    }

    public String getMessage() {
        return message;
    }

    public int getPrice() {
        return price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BonusNumberMatch getBonusNumberMatch() {
        return bonusNumberMatch;
    }
}
