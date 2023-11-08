package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private List<Long> correctWinningsCount = new ArrayList<>();
    private List<Boolean> correctBonuses = new ArrayList<>();

    public LottoResult(List<List<Integer>> userNumbers, List<Integer> winningNumber, int bonusNumber) {
        LottoMatcher lottoMatcher = new LottoMatcher();
        for (List<Integer> userNumber : userNumbers) {
            long winning = lottoMatcher.calculateCorrectWinning(userNumber, winningNumber);
            boolean bonus = lottoMatcher.calculateCorrectBonus(userNumber, bonusNumber);

            correctBonuses.add(bonus);
            correctWinningsCount.add(winning);
        }
    }

    public List<Long> toLongList() {
        return correctWinningsCount;
    }

    public List<Boolean> toBoolList() {
        return correctBonuses;
    }
}
