package lotto.domain.model;

import static lotto.domain.model.PrizeConstant.FIFTH_PLACE;
import static lotto.domain.model.PrizeConstant.FIFTH_REWARD;
import static lotto.domain.model.PrizeConstant.FIRST_PLACE;
import static lotto.domain.model.PrizeConstant.FIRST_REWARD;
import static lotto.domain.model.PrizeConstant.FOURTH_PLACE;
import static lotto.domain.model.PrizeConstant.FOURTH_REWARD;
import static lotto.domain.model.PrizeConstant.NO_PLACE;
import static lotto.domain.model.PrizeConstant.NO_REWARD;
import static lotto.domain.model.PrizeConstant.SECOND_PLACE;
import static lotto.domain.model.PrizeConstant.SECOND_REWARD;
import static lotto.domain.model.PrizeConstant.THIRD_PLACE;
import static lotto.domain.model.PrizeConstant.THIRD_REWARD;

import java.util.Map;

public enum Rank {
    FIRST_RANK(FIRST_REWARD,6),
    SECOND_RANK(SECOND_REWARD,5),
    THIRD_RANK(THIRD_REWARD, 5),
    FOURTH_RANK(FOURTH_REWARD, 4),
    FIFTH_RANK(FIFTH_REWARD, 3),
    NOT_FOUND(NO_REWARD,0);

    private final Map<Integer, Integer> prizeToOrderMapper = Map.ofEntries(
            Map.entry(FIRST_REWARD,FIRST_PLACE),
            Map.entry(SECOND_REWARD, SECOND_PLACE),
            Map.entry(THIRD_REWARD, THIRD_PLACE),
            Map.entry(FOURTH_REWARD, FOURTH_PLACE),
            Map.entry(FIFTH_REWARD, FIFTH_PLACE),
            Map.entry(NO_REWARD, NO_PLACE)
    );
    private final int prize;

    private final int matchCount;
    private final int order;
    Rank(int reward, int matchCount) {
        this.prize = reward;
        this.matchCount = matchCount;
        this.order = mappingRewardToOrder(reward);

    }

    public int getPrize() {
        return prize;
    }

    private Integer mappingRewardToOrder(Integer reward){
        return prizeToOrderMapper.get(reward);
    }

    public int getOrder() {
        return order;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public String toString() {
        if (this.order == SECOND_PLACE){
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - ",this.matchCount, this.prize);
        }
        return String.format("%d개 일치 (%,d원) - ",this.matchCount ,this.prize);
    }
}
