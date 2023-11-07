package lotto.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Referee {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final List<Integer> lottoRank;

    public Referee(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        Collections.sort(this.winningNumbers);
        this.bonusNumber = bonusNumber;
        this.lottoRank = new ArrayList<>();
    }

    public void increaseCountForRank(int rank) {
        int count = this.lottoRank.get(rank);
        this.lottoRank.set(rank, count + 1);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getLottoRank() {
        return lottoRank;
    }
}
