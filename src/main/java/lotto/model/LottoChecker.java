package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {

    private List<LottoRank> lottoRanks;

    private List<Integer> winningNumbers;

    private int bonusNumber;

    public LottoChecker(List<Integer> winningNumbers, int bonusNumber) {
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
            long matchCount = lotto.compareLottoNumbers(winningNumbers);
            boolean bonus = lotto.compareBonusNumber(bonusNumber);
            lottoRanks.add(LottoRank.valueOf(matchCount, bonus));
        }
        return lottoRanks;
    }


}
