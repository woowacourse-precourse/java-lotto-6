package lotto.domain;

import java.util.*;

public class Player {
    public static final Map<RankingStatus,Integer> rankings = new HashMap<RankingStatus, Integer>();
    public int money;

    public Player(int money){
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

    public double calculateReward(){
        double rewardMoney = 0;

        Iterator<RankingStatus> rankIterator = rankings.keySet().iterator();
        while (rankIterator.hasNext()) {
            RankingStatus r = rankIterator.next();
            Integer v = rankings.get(r);
            rewardMoney += r.reward * (double)v;
        }
        return Math.round(rewardMoney/money*1000)/(double)10;
    }



}
