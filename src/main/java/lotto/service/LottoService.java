package lotto.service;

import java.util.List;
import lotto.constant.PrizeCondition;
import lotto.constant.PrizeMoney;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.domain.dto.LottoPrizeDto;

public class LottoService {
    private static final int THOUSAND = 1000;
    private static final double TEN = 10.0;

    private final LottoList lottoList;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoService(LottoList lottoList, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoList = lottoList;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoPrizeDto compareLottos() {
        LottoPrizeDto lottoPrizeDto = new LottoPrizeDto();
        for (Lotto lotto : lottoList.getLottos()) {
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

    public double calculateRateOfReturn() {
        LottoPrizeDto dto = compareLottos();
        long totalPrizeMoney = dto.getFirst() * PrizeMoney.FIRST.getValue()
                + dto.getSecond() * PrizeMoney.SECOND.getValue()
                + dto.getThird() * PrizeMoney.THIRD.getValue()
                + dto.getFourth() * PrizeMoney.FOURTH.getValue()
                + dto.getFifth() * PrizeMoney.FIFTH.getValue();

        int purchase = lottoList.getLottos().size() * Money.EACH_LOTTO;

        return Math.round(THOUSAND * totalPrizeMoney / (double) purchase) / TEN;
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
