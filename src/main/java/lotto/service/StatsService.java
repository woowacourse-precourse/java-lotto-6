package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Player;

public class StatsService {
    private static final Integer THREE_MATCH_AMOUNT = 5000;
    private static final Integer FOUR_MATCH_AMOUNT = 50000;
    private static final Integer FIVE_MATCH_AMOUNT = 1500000;
    private static final Integer FIVE_MATCH_WITH_BONUS_AMOUNT = 30000000;
    private static final Integer SIX_MATCH_AMOUNT = 2000000000;
    private Player player;
    private String profitRate;

    public StatsService(Player player) {
        this.player = player;
    }

    public void calculateWinnings(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto, player.getLotto());
            addMatch(lotto, matchCount);
        }
        calculateProfitRate();
    }

    public int countMatchingNumbers(Lotto lotto, Lotto winningNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();

        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isContainBonus(Lotto lotto, int bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(bonusNumber);
    }

    public void addMatch(Lotto lotto, int matchCount) {
        if (matchCount == 3) {
            player.addThreeMatch();
        } else if (matchCount == 4) {
            player.addFourMatch();
        } else if (matchCount == 5) {
            boolean hasBonus = isContainBonus(lotto, player.getBonusNumber());
            if (hasBonus) {
                player.addFiveMatchWithBonus();
            } else {
                player.addFiveMatch();
            }
        } else if (matchCount == 6) {
            player.addSixMatch();
        }
    }

    public void calculateProfitRate() {
        int totalWinnings = calculateTotalWinnings();
        double profitRatePercent = (totalWinnings - player.getPayment()) / (double) player.getPayment() * 100;
        profitRate = formatProfitRate(profitRatePercent);
    }

    public int calculateTotalWinnings() {
        int totalWinnings = 0;
        totalWinnings += player.getThreeMatch() * THREE_MATCH_AMOUNT;
        totalWinnings += player.getFourMatch() * FOUR_MATCH_AMOUNT;
        totalWinnings += player.getFiveMatch() * FIVE_MATCH_AMOUNT;
        totalWinnings += player.getFiveMatchWithBonus() * FIVE_MATCH_WITH_BONUS_AMOUNT;
        totalWinnings += player.getSixMatch() * SIX_MATCH_AMOUNT;
        return totalWinnings;
    }

    public String formatProfitRate(double profitRate) {
        double roundedProfitRate = Math.round(profitRate * 10.0) / 10.0;
        return String.format("%.1f%%", roundedProfitRate);
    }
}
