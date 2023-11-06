package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum RankGroup {
    FIRST(false, 6, 0, 2000000000, RankTemplate.FIRST),
    SECOND(true, 5, 0, 30000000, RankTemplate.SECOND),
    THIRD(false,5, 0, 1500000, RankTemplate.THIRD),
    FOURTH(false,4, 0, 50000, RankTemplate.FOURTH),
    FIFTH(false, 3, 0, 5000, RankTemplate.FIFTH)
    ;
    private boolean haveBonusNumber;

    private int lottoNumberCount;
    private int result;
    private int reward;
    private RankTemplate template;
    RankGroup(boolean haveBonusNumber, int lottoNumberCount, int result, int reward, RankTemplate template){
        this.haveBonusNumber = haveBonusNumber;
        this.lottoNumberCount = lottoNumberCount;
        this.result = result;
        this.reward = reward;
        this.template = template;
    }

    public static Optional<RankGroup> findByLotto(boolean bonus, int lotto){
        return Arrays.stream(RankGroup.values())
                .filter(rankGroup -> rankGroup.haveBonusNumber == bonus && rankGroup.lottoNumberCount == lotto)
                .findAny();
    }

    public static void increaseResult(RankGroup group){
        group.result++;
    }

    public static int getTotalReward(){
        int total = 0;
        for(RankGroup rankGroup: RankGroup.values()){
            total += rankGroup.result * rankGroup.reward;
        }
        return total;
    }
    public String getTemplate(){
        return template.getTemplate();
    }
    public int getReward(){
        return reward;
    }
    public int getResult(){
        return result;
    }
}
