package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoResult> resultOfLottoTickets(WinningNumbers winningNumbers){
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : this.lottoTickets) {
            int matchCount = lotto.countMatchNumber(winningNumbers.getWinningNumbers());
            int bonusMatchCount = 0;
            if(lotto.isContainNumber(winningNumbers.getBonusNumber())){
                bonusMatchCount++;
            }
            lottoResults.add(new LottoResult(matchCount, bonusMatchCount));
        }
        return lottoResults;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
