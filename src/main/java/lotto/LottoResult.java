package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private int[] result;

    public LottoResult() {
        result = new int[5];
    }

    public void setRanking(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchedNumbers = getMatchedNumber(lotto, winningNumbers);
            boolean matchedBonus = isMatchedBonusNumber(lotto, bonusNumber);
            setResult(matchedNumbers, matchedBonus);
        }
    }

    private void setResult(int matchedNumbers, boolean matchedBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchedNumbers() == matchedNumbers && (!rank.isBonusMatch() || matchedBonus)) {
                result[rank.ordinal()]++;
            }
        }
    }

    private int getMatchedNumber(Lotto lotto, Lotto winningNumbers) {
        int matchedCount = 0;
        for (int j = 0; j < 6; j++) {
            if (lotto.contains(winningNumbers.getNumbers().get(j)))
                matchedCount++;
        }
        return matchedCount;
    }

    private boolean isMatchedBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public String toString() {
        List<String> resultDescription = new ArrayList<>();
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank rank = Rank.values()[i];
            resultDescription.add(rank.getDescription() + " - " + result[rank.ordinal()] + "개");
        }
        return String.join("\n", resultDescription);
    }
}
