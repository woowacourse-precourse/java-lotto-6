package lotto.Model.Service;

import lotto.Model.Domain.Statics;
import lotto.Model.Util.StaticsUtil;

public class StaticsService {

    private final StaticsUtil staticsUtil;
    private final LottoService lottoService;
    private final RaffleService raffleService;

    public StaticsService(StaticsUtil staticsUtil, LottoService lottoService,
            RaffleService raffleService) {
        this.staticsUtil = staticsUtil;
        this.lottoService = lottoService;
        this.raffleService = raffleService;
    }

    public Statics createStatics() {
        return staticsUtil.setResult(lottoService.getLottos(), raffleService.getRaffle(),
                lottoService.getPurchaseMoney());
    }
}
