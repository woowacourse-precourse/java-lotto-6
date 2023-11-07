package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.Validator;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final int bonusNumber;


    public WinningNumbers(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        Validator.validateBonusNumber(winningNumbers.getNumbers(), bonusNumber);
    }

    public Map<Prize, Integer> calculatePrizes(List<Lotto> lottoTickets) {
        Map<Prize, Integer> prizeResults = new HashMap<>();

        for (Prize prize : Prize.values()) {
            prizeResults.put(prize, 0);
        }

        for (Lotto lotto : lottoTickets) {
            int matchCount = countMatchingNumbers(lotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            Prize prize = Prize.valueOf(matchCount, bonusMatch);
            prizeResults.put(prize, prizeResults.getOrDefault(prize, 0) + 1);//무슨의미?
        }

        return prizeResults;
    }

    private int countMatchingNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return (int) lottoNumbers.stream()
            .filter(winningNumbers.getNumbers()::contains)
            .count();
    }


}
