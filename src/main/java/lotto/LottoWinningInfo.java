package lotto;

import java.util.List;

public class LottoWinningInfo {
    private final List<Lotto> lottoList;
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public LottoWinningInfo(List<Lotto> lottoList, List<Integer> winningNumber, int bonusNumber) {
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
}
