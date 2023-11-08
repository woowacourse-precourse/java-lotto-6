package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Player;

public class StatsService {
    private Player player;

    public StatsService(Player player) {
        this.player = player;
    }

    public void calculateWinnings(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto, player.getLotto());
            addMatch(lotto, matchCount);
        }

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
}
