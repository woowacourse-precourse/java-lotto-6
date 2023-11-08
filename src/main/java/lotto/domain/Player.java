package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Player {
    public static final Map<RankingStatus,Integer> rankings = new HashMap<RankingStatus, Integer>();
    public Player(){
        Arrays.stream(RankingStatus.values())
                .forEach(rank -> rankings.put(rank, 0));
        }
    public int countTickets(int money){
        validateDivisibleMoney(money);
        return money / 1000;
    }
    private static void validateDivisibleMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]1,000원 단위로만 입력가능합니다.");
        }
    }
    public Map<RankingStatus, Integer> countRanking(RankingStatus rank) {
        rankings.put(rank,rankings.get(rank)+1);
        return rankings;
    }

}
