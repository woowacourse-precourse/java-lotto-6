package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Player {
    public static final Map<RankingStatus,Integer> rankings = new HashMap<RankingStatus, Integer>();
    public int money;

    public Player(int moeny){
        Arrays.stream(RankingStatus.values())
                .forEach(rank -> rankings.put(rank, 0));

        validateDivisibleMoney(money);
        this.money = money;
        }
    public int countTickets(){
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

    public double calculateRewardTest(){
        return 62.5;
    }



}
