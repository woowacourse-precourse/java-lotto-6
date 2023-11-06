package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoNumbers> lottoTickets;

    public LottoTickets(List<LottoNumbers> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoResult> resultOfLottoTickets(WinningNumbers winningNumbers){
        List<LottoResult> lottoResults = new ArrayList<>();
        for (LottoNumbers lottoNumbers : this.lottoTickets) {
            int matchCount = lottoNumbers.countMatchNumber(winningNumbers.getWinningNumbers());
            int bonusMatchCount = 0;
            if(lottoNumbers.isContainNumber(winningNumbers.getBonusNumber())){
                bonusMatchCount++;
            }
            lottoResults.add(new LottoResult(matchCount, bonusMatchCount));
        }
        return lottoResults;
    }
}
