package lotto.domain;

import lotto.constant.LottoPrice;
import lotto.service.MessageService;

public class LottoReturn {
    private final LottoCount lottoCount;
    private final MessageService messageService = new MessageService();
    private static final double ZERO = 0;
    private static final double HUNDRED = 100;

    public LottoReturn(LottoCount lottoCount) {
        this.lottoCount = lottoCount;
    }

    public double getLottoReturnRate(int purchasePrice) {
        int lottoReturn = getLottoReturn();
        if (lottoReturn == 0) {
            messageService.outputLottoReturnRate(ZERO);
            return 0;
        }
        double returnRate = (double) (lottoReturn - purchasePrice) / purchasePrice * HUNDRED + HUNDRED;
        messageService.outputLottoReturnRate(returnRate);
        return returnRate;
    }

    private int getLottoReturn() {
        return (lottoCount.getSixCount() * LottoPrice.FIRST.getPrice()
                + lottoCount.getFiveWithBonusCount() * LottoPrice.SECOND.getPrice()
                + lottoCount.getFiveCount() * LottoPrice.THIRD.getPrice()
                + lottoCount.getFourCount() * LottoPrice.FOURTH.getPrice()
                + lottoCount.getThreeCount() * LottoPrice.FIFTH.getPrice());
    }
}
