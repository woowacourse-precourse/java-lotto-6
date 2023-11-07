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
    private static final double TEN_POINT_ZERO = 10.0;

    public LottoPrizeDto compareLottos(LottoList lottoList, List<Integer> winningNumbers, int bonusNumber) {
        LottoPrizeDto lottoPrizeDto = new LottoPrizeDto();
        for (Lotto lotto : lottoList.getLottos()) {
            if (compareOneLotto(lotto, winningNumbers, bonusNumber) == PrizeCondition.FIRST) {
                lottoPrizeDto.countFirst();
            }
            if (compareOneLotto(lotto, winningNumbers, bonusNumber) == PrizeCondition.SECOND) {
                lottoPrizeDto.countSecond();
            }
            if (compareOneLotto(lotto, winningNumbers, bonusNumber) == PrizeCondition.THIRD) {
                lottoPrizeDto.countThird();
            }
            if (compareOneLotto(lotto, winningNumbers, bonusNumber) == PrizeCondition.FOURTH) {
                lottoPrizeDto.countFourth();
            }
            if (compareOneLotto(lotto, winningNumbers, bonusNumber) == PrizeCondition.FIFTH) {
                lottoPrizeDto.countFifth();
            }
        }
        return lottoPrizeDto;
    }

    public double calculateRateOfReturn(LottoList lottoList, List<Integer> winningNumbers, int bonusNumber) {
        LottoPrizeDto dto = compareLottos(lottoList, winningNumbers, bonusNumber);
        long totalPrizeMoney = dto.getFirst() * PrizeMoney.FIRST.getValue()
                + dto.getSecond() * PrizeMoney.SECOND.getValue()
                + dto.getThird() * PrizeMoney.THIRD.getValue()
                + dto.getFourth() * PrizeMoney.FOURTH.getValue()
                + dto.getFifth() * PrizeMoney.FIFTH.getValue();

        int purchase = lottoList.getLottos().size() * Money.EACH_LOTTO;

        return Math.round(THOUSAND * totalPrizeMoney / (double) purchase) / TEN_POINT_ZERO;
    }

    private PrizeCondition compareOneLotto(Lotto randomLotto, List<Integer> winningNumbers, int bonusNumber) {
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
