package lotto.domain;

import java.util.List;

public class LottoManager {

    private final List<Integer> winningLottoNumbers;
    private List<Integer> matchingCounts;

    public LottoManager(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.matchingCounts = List.of();
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public void addMatchingCount(int matchingCount) {
        matchingCounts.add(matchingCount);
    }
}
