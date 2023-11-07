package lotto.service;

import lotto.constant.PrizeCondition;
import lotto.constant.PrizeMoney;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoNumber;
import lotto.domain.dto.LottoPrizeDto;
import lotto.domain.dto.LottoPurchaseDto;

public class LottoService {
    private static final int THOUSAND = 1000;
    private static final double TEN_POINT_ZERO = 10.0;

    public LottoPrizeDto totalWinnings(LottoPurchaseDto lottoPurchaseDto) {
        LottoList lottoList = lottoPurchaseDto.getLottoList();
        Lotto winningLotto = lottoPurchaseDto.getWinningLotto();
        LottoNumber bonusNumber = lottoPurchaseDto.getBonusNumber();

        return checkLottoWinnings(lottoList, winningLotto, bonusNumber);
    }

    public double calculateRateOfReturn(LottoPurchaseDto lottoPurchaseDto) {
        LottoPrizeDto dto = totalWinnings(lottoPurchaseDto);
        long totalPrizeMoney = dto.getFirst() * PrizeMoney.FIRST.getValue()
                + dto.getSecond() * PrizeMoney.SECOND.getValue()
                + dto.getThird() * PrizeMoney.THIRD.getValue()
                + dto.getFourth() * PrizeMoney.FOURTH.getValue()
                + dto.getFifth() * PrizeMoney.FIFTH.getValue();

        int cost = lottoPurchaseDto.getCost();
        return Math.round(THOUSAND * totalPrizeMoney / (double) cost) / TEN_POINT_ZERO;
    }

    private LottoPrizeDto checkLottoWinnings(LottoList lottoList, Lotto winningLotto,
                                             LottoNumber bonusNumber) {
        LottoPrizeDto lottoPrizeDto = new LottoPrizeDto();
        for (Lotto lotto : lottoList.getLottos()) {
            if (compareOneLotto(lotto, winningLotto, bonusNumber) == PrizeCondition.FIRST) {
                lottoPrizeDto.countFirst();
            }
            if (compareOneLotto(lotto, winningLotto, bonusNumber) == PrizeCondition.SECOND) {
                lottoPrizeDto.countSecond();
            }
            if (compareOneLotto(lotto, winningLotto, bonusNumber) == PrizeCondition.THIRD) {
                lottoPrizeDto.countThird();
            }
            if (compareOneLotto(lotto, winningLotto, bonusNumber) == PrizeCondition.FOURTH) {
                lottoPrizeDto.countFourth();
            }
            if (compareOneLotto(lotto, winningLotto, bonusNumber) == PrizeCondition.FIFTH) {
                lottoPrizeDto.countFifth();
            }
        }
        return lottoPrizeDto;
    }

    private PrizeCondition compareOneLotto(Lotto randomLotto, Lotto winningLotto,
                                           LottoNumber bonusNumber) {
        return PrizeCondition.findPrize(
                randomLotto.matchCount(winningLotto),
                randomLotto.contains(bonusNumber.getNumber()));
    }

}
