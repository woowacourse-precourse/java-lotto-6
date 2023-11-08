package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.RankingService;

public class AppConfig {
    private final LottoService lottoService;
    private final RankingService rankingService;
    private final LottoController lottosController;

    public AppConfig() {
        this.lottoService = new LottoService();
        this.rankingService = new RankingService();
        lottoService.setRankingService(rankingService);
        rankingService.setLottoService(lottoService);
        this.lottosController = new LottoController(lottoService, rankingService);
    }

    public LottoController lottosController() {
        return lottosController;
    }

    public LottoService lottoService() {
        return lottoService;
    }

    public RankingService rankingService() {
        return rankingService;
    }
}
