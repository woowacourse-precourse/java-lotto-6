package lotto.model;

import java.util.List;

public class LottoTicket {

    private final List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public int getMatchCountWithWinningNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int winningNumber : winningNumbers) {
            if (lottoTicket.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isMatchWithBonusNumber(int bonusNumber) {
        return lottoTicket.contains(bonusNumber);
    }
}
