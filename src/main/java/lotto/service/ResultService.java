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
    private final HashMap<Integer, Integer> rankCounts = new HashMap<>();
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

    public void deterMineScore(Lotto lotto) {
        Rank rank = scoreDeterminer.getRank(lotto);
        recordRankCountBy(rank.getRank());
        sumUpWinningsBy(rank.getAmount());
    }

    public int getCountOf(Rank rank) {
        int rankNumber = rank.getRank();
        if (rankCounts.containsKey(rankNumber)) {
            return rankCounts.get(rankNumber);
        }
        return NOTHING;
    }

    public double getProfitRatio() {
        return (double) winnings / seller.getAmount() * TO_PERCENTAGE;
    }

    private void recordRankCountBy(int rank) {
        if (rankCounts.containsKey(rank)) {
            rankCounts.put(rank, rankCounts.get(rank) + COUNT_ONE);
            return;
        }
        rankCounts.put(rank, COUNT_ONE);
    }

    private void sumUpWinningsBy(long amount) {
        winnings += amount;
    }
}
