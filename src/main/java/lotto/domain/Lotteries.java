package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.constants.Rank;

public class Lotteries {
    private static final String DELIMITER = "\n";
    private List<Lotto> lotteries;

    public Lotteries() {
        lotteries = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lotteries.add(lotto);
    }

    public String concatLotteries() {
        StringBuilder stringBuilder = new StringBuilder();
        lotteries.forEach(lotto -> {
            String lottoNumbers = lotto.concatNumbers();
            stringBuilder.append(lottoNumbers);
            stringBuilder.append(DELIMITER);
        });
        return stringBuilder.toString();
    }

    public String getResult(PurchaseAmount purchaseAmount, Lotto winningNumbers, BonusNumber bonusNumber) {
        EnumMap<Rank, Integer> ranks = initRanks();
        double totalPrize = 0;
        for (Lotto lotto : lotteries) {
            int matchCount = lotto.compareMatches(winningNumbers);
            boolean bonusMatch = bonusNumber.isMatch(lotto, matchCount);
            Rank rank = Rank.getRank(matchCount, bonusMatch);
            totalPrize += rank.getPrize();
            int winCount = ranks.get(rank);
            ranks.put(rank, winCount + 1);
        }
        double returnRate = purchaseAmount.getReturnRate(totalPrize);
        return createResult(ranks, returnRate);
    }

    private EnumMap<Rank, Integer> initRanks() {
        EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
        return ranks;
    }

    private String createResult(EnumMap<Rank, Integer> ranks, double returnRate) {
        String result = "당첨 통계\n---\n";
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NO_RANK) {
                continue;
            }
            int winCount = ranks.get(rank);
            result += rank.getMessage(winCount);
        }
        result += String.format("총 수익률은 %,.1f%%입니다.", returnRate);
        return result;
    }
}
