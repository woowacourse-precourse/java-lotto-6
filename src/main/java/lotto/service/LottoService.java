package lotto.service;

import lotto.constant.PrizeCondition;
import lotto.constant.PrizeMoney;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoNumber;
import lotto.domain.dto.LottoPrizeDto;
import lotto.domain.dto.LottoResultDto;

public class LottoService {
    private static final int THOUSAND = 1000;
    private static final double TEN_POINT_ZERO = 10.0;

    public LottoPrizeDto totalWinnings(LottoResultDto lottoResultDto) {
        LottoList lottoList = lottoResultDto.getLottoList();
        Lotto winningLotto = lottoResultDto.getWinningLotto();
        LottoNumber bonusNumber = lottoResultDto.getBonusNumber();

        return checkLottoWinnings(lottoList, winningLotto, bonusNumber);
    }

    public double calculateRateOfReturn(LottoResultDto lottoResultDto) {
        LottoPrizeDto dto = totalWinnings(lottoResultDto);
        long totalPrizeMoney = dto.getFirst() * PrizeMoney.FIRST.getValue()
                + dto.getSecond() * PrizeMoney.SECOND.getValue()
                + dto.getThird() * PrizeMoney.THIRD.getValue()
                + dto.getFourth() * PrizeMoney.FOURTH.getValue()
                + dto.getFifth() * PrizeMoney.FIFTH.getValue();

        int cost = lottoResultDto.getCost();
        return roundUpToTheTenthPlace(totalPrizeMoney / (double) cost);
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

    private double roundUpToTheTenthPlace(double number) {
        return Math.round(THOUSAND * number) / TEN_POINT_ZERO;
    }

}
