package lotto.service.calculate;

import lotto.dto.calculate.GetReturnRateDto;
import lotto.dto.input.GetLottoCountDto;
import lotto.dto.result.GetLottoResultDto;

public class LottoReturnRateCalculator implements Calculator{
    private static final int THOUSAND = 1000;
    private static final int THREE_HIT_PRIZE = 5000;
    private static final int FOUR_HIT_PRIZE = 50000;
    private static final int FIVE_HIT_PRIZE = 1500000;
    private static final int FIVE_HIT_WITH_BONUS_PRIZE = 30000000;
    private static final int SIX_HIT = 2000000000;
    private static final double HUNDRED_POINT = 100.0;
    private static final int HUNDRED = 100;
    @Override
    public GetReturnRateDto calculateLottoReturnRate(GetLottoResultDto getLottoResultDto,
                                                     GetLottoCountDto getLottoCountDto) {

        return new GetReturnRateDto(calculateRate(getLottoResultDto, getLottoCountDto));
    }

    private static double calculateRate(GetLottoResultDto getLottoResultDto, GetLottoCountDto getLottoCountDto) {
        return Math.round(getRate(getLottoResultDto, getLottoCountDto)*HUNDRED)/HUNDRED_POINT;
    }

    private static double getRate(GetLottoResultDto getLottoResultDto, GetLottoCountDto getLottoCountDto) {
        double rate = (double) calculateWinPrize(getLottoResultDto) / getBuyMoney(getLottoCountDto) * 100;
        return rate;
    }

    private static int getBuyMoney(GetLottoCountDto getLottoCountDto) {
        return getLottoCountDto.getCount() * THOUSAND;
    }

    private static int calculateWinPrize(GetLottoResultDto getLottoResultDto) {
        return getThreeHitPrize(getLottoResultDto)
                + getFourHitPrize(getLottoResultDto)
                + getFiveHitPrize(getLottoResultDto)
                + getFiveWithBonusPrize(getLottoResultDto)
                + getSixHitPrize(getLottoResultDto);
    }

    private static int getSixHitPrize(GetLottoResultDto getLottoResultDto) {
        return getLottoResultDto.sixHit() * SIX_HIT;
    }

    private static int getFiveWithBonusPrize(GetLottoResultDto getLottoResultDto) {
        return getLottoResultDto.fiveHitWithBonus() * FIVE_HIT_WITH_BONUS_PRIZE;
    }

    private static int getFiveHitPrize(GetLottoResultDto getLottoResultDto) {
        return getLottoResultDto.fiveHit() * FIVE_HIT_PRIZE;
    }

    private static int getFourHitPrize(GetLottoResultDto getLottoResultDto) {
        return getLottoResultDto.fourHit() * FOUR_HIT_PRIZE;
    }

    private static int getThreeHitPrize(GetLottoResultDto getLottoResultDto) {
        return getLottoResultDto.threeHit() * THREE_HIT_PRIZE;
    }
}
