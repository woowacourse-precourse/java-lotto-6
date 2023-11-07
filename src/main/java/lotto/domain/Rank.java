package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.RankConfig;

public class Rank {

    private static final int DECIDE_SIZE = 1;
    private static final int INDEX_ZERO = 0;


    public static RankConfig ranking(int matchedNumbers, boolean matchedBonus) {
        List<RankConfig> decideRanks = Arrays.stream(RankConfig.values())
                .filter(rank -> rank.getMatchedNumbers() == matchedNumbers)
                .collect(Collectors.toList());

        if(decideRanks.size() > DECIDE_SIZE){
            return decideSecondOrThird(matchedBonus);
        }

        return decideRanks.get(INDEX_ZERO);
    }

    private static RankConfig decideSecondOrThird(boolean correctBonusNumber){
        if(correctBonusNumber){
            return RankConfig.SECOND;
        }
        return RankConfig.THIRD;
    }
}
