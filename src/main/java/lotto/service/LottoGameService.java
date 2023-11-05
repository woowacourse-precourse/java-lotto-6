package lotto.service;

import java.util.List;
import lotto.constant.PrizeCondition;
import lotto.domain.Lotto;
import lotto.domain.LottoSet;
import lotto.domain.dto.LottoPrizeDto;

public class LottoGameService {
    private final LottoSet lottoSet;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    LottoGameService(LottoSet lottoSet, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoSet = lottoSet;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoPrizeDto compareLottos() {
        LottoPrizeDto lottoPrizeDto = new LottoPrizeDto();
        for (Lotto lotto : lottoSet.getLottos()) {
            if (compareOneLotto(lotto) == PrizeCondition.FIRST) {
                lottoPrizeDto.countFirst();
            }
            if (compareOneLotto(lotto) == PrizeCondition.SECOND) {
                lottoPrizeDto.countSecond();
            }
            if (compareOneLotto(lotto) == PrizeCondition.THIRD) {
                lottoPrizeDto.countThird();
            }
            if (compareOneLotto(lotto) == PrizeCondition.FOURTH) {
                lottoPrizeDto.countFourth();
            }
            if (compareOneLotto(lotto) == PrizeCondition.FIFTH) {
                lottoPrizeDto.countFifth();
            }
        }
        return lottoPrizeDto;
    }

    private PrizeCondition compareOneLotto(Lotto randomLotto) {
        int matchCount = 0;
        boolean bonusMatch = false;

        for (Integer number : winningNumbers) {
            if (randomLotto.contains(number)) {
                matchCount++;
            }
        }

        if (randomLotto.contains(bonusNumber)) {
            bonusMatch = true;
        }

        return PrizeCondition.findPrize(matchCount, bonusMatch);
    }

}
