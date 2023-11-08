package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> matchedNumber;
    public List<Integer> WinnersNumber = new ArrayList<>();

    public int totalPrize = 0;
    public Ranks rank;

    public User(List<Integer> matchedNumber) {
        this.matchedNumber = matchedNumber;
    }

    public void setRanks(boolean hasBonusBall) {
        for (Integer number : matchedNumber) {

            rank = Ranks.getRank(number, hasBonusBall);
            int prize = rank.getRankPrize();

            totalPrize += prize;
            getWinnersNumber(rank);
        }

    }

    public void getWinnersNumber(Ranks rank) {
        WinnersNumber.add(rank.getCount());
    }


    public float getProfitPercentage(int cost) {
        if (cost == 0) {
            return 0.0f;
        }
        return ((float) totalPrize / cost) * 100;
    }

    public List<Ranks> getAllRanks() {
        List<Ranks> ranksList = List.of(Ranks.values());
        return ranksList;
    }
}
