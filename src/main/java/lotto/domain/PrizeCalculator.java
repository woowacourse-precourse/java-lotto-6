package lotto.domain;

import java.util.EnumMap;

public class PrizeCalculator {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public PrizeCalculator(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }


    public LottoResult evaluateLotto(LottoTicket lottoTicket, int purchaseAmount) {
        EnumMap<Prize, Integer> prizeResults = calculatePrizes(lottoTicket);
        double earnRate = calculateEarnRate(prizeResults, purchaseAmount);
        return new LottoResult(prizeResults, earnRate);
    }

    private EnumMap<Prize, Integer> calculatePrizes(LottoTicket lottoTicket) {
        EnumMap<Prize, Integer> results = new EnumMap<>(Prize.class);
        for (Lotto lotto : lottoTicket.getLottoTickets()) {
            Prize prize = calculatePrize(lotto);
            results.merge(prize, 1, Integer::sum);
        }
        return results;
    }

    private Prize calculatePrize(Lotto lotto) {
        boolean matchBonus = false;
        int matchCount = getMatchCount(lotto);
        if (matchCount == 5) {
            matchBonus = lotto.getNumbers().contains(bonusNumber);
        }
        return Prize.valueOf(matchCount, matchBonus);
    }

    private int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private double calculateEarnRate(EnumMap<Prize, Integer> prizeResults, int purchaseAmount) {
        long totalPrizeMoney = prizeResults.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
        double earnRate = (totalPrizeMoney / (double) purchaseAmount) * 100;
        return Math.round(earnRate * 100) / 100.0;
    }
}
