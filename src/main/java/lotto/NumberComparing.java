package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberComparing {
    private final int SIZEOFLOTTONUMBERS = 6;

    private final List<Integer> winningNumbers;

    public NumberComparing(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getNumberOfMatch(Lotto lotto) {
        HashSet<Integer> lottoNumberBundle = new HashSet<>(lotto.getNumbers());
        HashSet<Integer> winningNumbersBundle = new HashSet<>(winningNumbers);

        lottoNumberBundle.retainAll(winningNumbersBundle);

        int result = SIZEOFLOTTONUMBERS - lottoNumberBundle.size();

        return result;
    }

    public List<Integer> getNumberOfMatchResults(List<Lotto> lottos) {
        List<Integer> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            results.add(getNumberOfMatch(lotto));
        }

        return results;
    }
}
