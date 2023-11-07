package lotto.global.constant;

import java.util.HashMap;
import java.util.Map;
import static lotto.global.constant.LottoConstant.*;

public enum LottoRankAndPrize {

    FIRST_RANK(FIRST_PRIZE, FIRST_RANK_LOTTO_MATCHED, false),
    SECOND_RANK(SECOND_PRIZE, SECOND_RANK_LOTTO_MATCHED, true),
    THIRD_RANK(THIRD_PRIZE, THIRD_RANK_LOTTO_MATCHED, false),
    FOURTH_RANK(FOURTH_PRIZE, FOURTH_RANK_LOTTO_MATCHED, false),
    FIFTH_RANK(FIFTH_PRIZE, FIFTH_RANK_LOTTO_MATCHED, false),
    NO_RANK(0,0,false);

    public static String PRINT_FIRST_RANK = "6개 일치 (2,000,000,000원) - ";
    public static String PRINT_SECOND_RANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static String PRINT_THIRD_RANK = "5개 일치 (1,500,000원) - ";
    public static String PRINT_FOURTH_RANK = "4개 일치 (50,000원) - ";
    public static String PRINT_FIFTH_RANK = "3개 일치 (5,000원) - ";

    private final int prize;
    private final int lottoMatched;
    private final boolean bonusMatched;

    LottoRankAndPrize(int prize, int lottoMatched, boolean bonusMatched) {
        this.prize = prize;
        this.lottoMatched = lottoMatched;
        this.bonusMatched = bonusMatched;
    }

    public int getPrize() {
        return prize;
    }

    public int getLottoMatched() {
        return lottoMatched;
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }

    public static LottoRankAndPrize determineRankByLottoMatched(int lottoMatched, boolean bonusMatched){
        for(LottoRankAndPrize rankAndPrize : LottoRankAndPrize.values()) {
            if(rankAndPrize.lottoMatched == lottoMatched && rankAndPrize.bonusMatched == bonusMatched) {
                return rankAndPrize;
            }
        }
        return NO_RANK;
    }

    public static String printFirstRank(int rankCount){
        return printLottoRankFormat(PRINT_FIRST_RANK, rankCount);
    }

    public static String printSecondRank(int rankCount){
        return printLottoRankFormat(PRINT_SECOND_RANK, rankCount);
    }

    public static String printThirdRank(int rankCount){
        return printLottoRankFormat(PRINT_THIRD_RANK, rankCount);
    }

    public static String printFourthRank(int rankCount){
        return printLottoRankFormat(PRINT_FOURTH_RANK, rankCount);
    }

    public static String printFifthRank(int rankCount){
        return printLottoRankFormat(PRINT_FIFTH_RANK, rankCount);
    }

    public static String printLottoRankFormat(String lottoRankMessage, int rankCount){
        return lottoRankMessage + rankCount + "개";
    }

}
