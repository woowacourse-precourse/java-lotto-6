package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.awt.image.LookupTable;
import java.util.ArrayList;
import java.util.List;
import lotto.LottoGenerator;

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
