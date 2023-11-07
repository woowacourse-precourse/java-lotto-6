package lotto.service;

import java.util.List;
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
        List<LottoNumber> winningNumbers = lottoPurchaseDto.getWinningNumbers();
        LottoNumber bonusNumber = lottoPurchaseDto.getBonusNumber();

        return checkLottoWinnings(lottoList, winningNumbers, bonusNumber);
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

    private LottoPrizeDto checkLottoWinnings(LottoList lottoList, List<LottoNumber> winningNumbers,
                                             LottoNumber bonusNumber) {
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

    private PrizeCondition compareOneLotto(Lotto randomLotto, List<LottoNumber> winningNumbers,
                                           LottoNumber bonusNumber) {
        int matchCount = 0;
        boolean bonusMatch = false;
        for (LottoNumber lottoNumber : winningNumbers) {
            if (randomLotto.contains(lottoNumber.getNumber())) {
                matchCount++;
            }
        }
        if (randomLotto.contains(bonusNumber.getNumber())) {
            bonusMatch = true;
        }
        return PrizeCondition.findPrize(matchCount, bonusMatch);
    }

}
