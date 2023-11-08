package lotto;

import java.util.List;

public class LottoWinningNumber {
    private final List<Lotto> lottoList;
    private final List<Integer> winningNumber;

    private final int bonusNumber;

    public LottoWinningNumber(List<Lotto> lottoList, List<Integer> winningNumber, int bonusNumber) {
        this.lottoList = lottoList;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
