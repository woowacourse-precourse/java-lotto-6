package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RankTest {

    private static final int THIRD_RANK_REWARD = 1_500_000;
    private static final int FIFTH_RANK_REWARD = 5_000;
    private static final int NUMBER_OF_THIRD_REWARD_WINNERS = 1;
    private static final int NUMBER_OF_FIFTH_REWARD_WINNERS = 3;

    @Test
    public void 당첨_번호와_로또_번호가_일치하는_개수가_6개이면_1등입니다() {
        // given
        final int matchingNumber = 6;
        final boolean bonusMatch = false;

        // when
        final Rank firstRank = Rank.find(matchingNumber, bonusMatch);

        // then
        Assertions.assertEquals(firstRank, Rank.FIRST);
    }

    @Test
    public void 당첨_번호와_로또_번호가_일치하는_개수가_5개이면서_보너스_번호도_일치하면_2등입니다() {
        // given
        final int matchingNumber = 5;
        final boolean bonusMatch = true;

        // when
        final Rank firstRank = Rank.find(matchingNumber, bonusMatch);

        // then
        Assertions.assertEquals(firstRank, Rank.SECOND);
    }

    @Test
    public void 당첨_번호와_로또_번호가_일치하는_개수가_5개이면서_보너스_번호가_일치하지_않으면_3등입니다() {
        // given
        final int matchingNumber = 5;
        final boolean bonusMatch = false;

        // when
        final Rank firstRank = Rank.find(matchingNumber, bonusMatch);

        // then
        Assertions.assertEquals(firstRank, Rank.THIRD);
    }

    @Test
    public void 당첨_번호와_로또_번호가_일치하는_개수가_4개이면_4등입니다() {
        // given
        final int matchingNumber = 4;
        final boolean bonusMatch = false;

        // when
        final Rank firstRank = Rank.find(matchingNumber, bonusMatch);

        // then
        Assertions.assertEquals(firstRank, Rank.FOURTH);
    }

    @Test
    public void 당첨_번호와_로또_번호가_일치하는_개수가_3개이면_5등입니다() {
        // given
        final int matchingNumber = 3;
        final boolean bonusMatch = false;

        // when
        final Rank firstRank = Rank.find(matchingNumber, bonusMatch);

        // then
        Assertions.assertEquals(firstRank, Rank.FIFTH);
    }
    
    @Test
    public void 당첨_금액의_총합_기능_테스트() {
        // given
        final Map<Rank, Integer> result = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));

        result.put(Rank.FIFTH, NUMBER_OF_FIFTH_REWARD_WINNERS);
        result.put(Rank.THIRD, NUMBER_OF_THIRD_REWARD_WINNERS);
        
        // when
        final int totalReward = Rank.calculateTotalReward(result);

        // then
        Assertions.assertEquals(totalReward, THIRD_RANK_REWARD * NUMBER_OF_THIRD_REWARD_WINNERS
                + FIFTH_RANK_REWARD * NUMBER_OF_FIFTH_REWARD_WINNERS);
    }
}