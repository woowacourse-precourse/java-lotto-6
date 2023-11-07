package lotto.service;

import java.util.HashMap;
import java.util.List;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.ScoreDeterminer;
import lotto.domain.Seller;
import lotto.utils.StringChanger;

public class ResultService {
    private static final int NOTHING = 0;
    private static final int COUNT_ONE = 1;
    private static final int TO_PERCENTAGE = 100;

    private final Seller seller = new Seller();
    private final ScoreDeterminer scoreDeterminer = new ScoreDeterminer();
    private final HashMap<Rank, Integer> rankCounts = new HashMap<>();
    private long winnings = NOTHING;

    public void setAmount(String userInput) {
        userInput = StringChanger.toTrimmedString(userInput);
        seller.setAmount(userInput);
    }

    public List<Lotto> getUserLotto() {
        return seller.giveLotto();
    }

    public void setFirstRankNumbers(String userInput) {
        List<String> inputNumbers = StringChanger.toTrimmedStringList(userInput);
        scoreDeterminer.setFirstRankNumbers(inputNumbers);
    }

    public void setBonusNumber(String userInput) {
        userInput = StringChanger.toTrimmedString(userInput);
        scoreDeterminer.setBonusNumber(userInput);
    }

    public void determineScore(Lotto lotto) {
        Rank rank = scoreDeterminer.getRankOf(lotto);
        recordCountOf(rank);
        addUpTo(rank.getWinnings());
    }

    public int getCountOf(Rank rank) {
        if (rankCounts.containsKey(rank)) {
            return rankCounts.get(rank);
        }
        return NOTHING;
    }

    public double getProfitRatio() {
        int amount = seller.getAmount();
        if (amount == NOTHING && winnings == NOTHING) {
            return TO_PERCENTAGE;
        }
        if (amount == NOTHING) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) winnings / amount * TO_PERCENTAGE;
    }

    private void recordCountOf(Rank rank) {
        if (rankCounts.containsKey(rank)) {
            rankCounts.put(rank, rankCounts.get(rank) + COUNT_ONE);
            return;
        }
        rankCounts.put(rank, COUNT_ONE);
    }

    private void addUpTo(long winnings) {
        this.winnings += winnings;
    }
}
