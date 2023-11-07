package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {

    private List<LottoRank> lottoRanks;

    private WinningNumbers winningNumbers;

    private BonusNumber bonusNumber;

    public LottoChecker(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.lottoRanks = new ArrayList<>();
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }


    public LottoRankInfo createResult(Lottos lottos) {
        lottoRanks = createLottoRanks(lottos);
        return LottoRankInfo.from(lottoRanks);
    }

    public List<LottoRank> createLottoRanks(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            long matchCount = winningNumbers.compareWinningNumbers(lotto.getNumbers());
            boolean bonus = bonusNumber.compareBonusNumber(lotto.getNumbers());
            lottoRanks.add(LottoRank.valueOf(matchCount, bonus));
        }
        return lottoRanks;
    }


}
