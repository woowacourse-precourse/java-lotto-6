package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final int PERCENTAGE_MULTIPLIER =100;
    private static final double ROUNDING_FACTOR =100.0;
    private static final double DECIMAL_PRECISION =100.0;
    private HashMap<Prize,Integer> result;
    private int purchaseAmount;

    public Result() {
        result = new HashMap<>();
        result.put(Prize.NONE,0);
        result.put(Prize.THREE_MATCH,0);
        result.put(Prize.FOUR_MATCH,0);
        result.put(Prize.FIVE_MATCH,0);
        result.put(Prize.FIVE_MATCH_WITH_BONUS, 0);
        result.put(Prize.SIX_MATCH,0);
    }

    public void recordLottoResults(List<Lotto> lottoTickets, List<Integer> lottoWinningNumbers, int bonusNumber) {
        purchaseAmount = lottoTickets.size()*1000;
        for (Lotto lotto : lottoTickets) {
            int numberOfMatches = lotto.countMatchingNumbers(lottoWinningNumbers);
            boolean isBonusNumberMatch = lotto.checkBonusNumber(bonusNumber);
            Prize prize = getPrizeForMatches(numberOfMatches,isBonusNumberMatch);
            result.put(prize, result.get(prize) + 1);
        }
    }
    private Prize getPrizeForMatches(int numberOfMatches, boolean isBonusNumberMatch) {
        if(numberOfMatches == Prize.THREE_MATCH.getNumberOfMatches())
            return Prize.THREE_MATCH;
        else if (numberOfMatches == Prize.FOUR_MATCH.getNumberOfMatches())
            return Prize.FOUR_MATCH;
        else if (numberOfMatches == Prize.FIVE_MATCH.getNumberOfMatches() && !isBonusNumberMatch)
            return Prize.FIVE_MATCH;
        else if (numberOfMatches == Prize.FIVE_MATCH_WITH_BONUS.getNumberOfMatches() && isBonusNumberMatch)
            return Prize.FIVE_MATCH_WITH_BONUS;
        else if (numberOfMatches == Prize.SIX_MATCH.getNumberOfMatches())
            return Prize.SIX_MATCH;

        return Prize.NONE;
    }
    public double calculateProfitRate(){
        int totalAmount = 0;
        for (Map.Entry<Prize, Integer> entry : result.entrySet()) {
            Prize prize = entry.getKey();
            int prizeAmount = prize.getPrizeAmount();
            int numberOfWinners = entry.getValue();

            totalAmount += prizeAmount * numberOfWinners;
        }
        double profitRate = ((double) totalAmount / purchaseAmount) * PERCENTAGE_MULTIPLIER;
        double roundedProfitRate = Math.round(profitRate * ROUNDING_FACTOR) / DECIMAL_PRECISION;

        return roundedProfitRate;
    }
    public HashMap<Prize, Integer> getResult() {
        return result;
    }
}
