package lotto;

import lotto.Controller.LottoController;
import lotto.Controller.RaffleController;
import lotto.Controller.StaticsController;
import lotto.Model.Service.LottoService;
import lotto.Model.Service.RaffleService;
import lotto.Model.Service.StaticsService;
import lotto.Model.Util.LottoUtil;
import lotto.Model.Util.RaffleUtil;
import lotto.Model.Util.StaticsUtil;
import lotto.View.LottoInput;
import lotto.View.LottoOutput;

public class LottoProcessor {

    private final LottoInput lottoInput = new LottoInput();
    private final LottoOutput lottoOutput = new LottoOutput();

    private final LottoUtil lottoUtil = new LottoUtil();
    private final LottoService lottoService = new LottoService(lottoUtil);
    private final LottoController lottoController = new LottoController(lottoService,
            lottoInput, lottoOutput);

    private final RaffleUtil raffleUtil = new RaffleUtil();
    private final RaffleService raffleService = new RaffleService(raffleUtil);
    private final RaffleController raffleController = new RaffleController(raffleService,
            lottoInput);

    private final StaticsUtil staticsUtil = new StaticsUtil();
    private final StaticsService staticsService = new StaticsService(staticsUtil, lottoService,
            raffleService);
    private final StaticsController staticsController = new StaticsController(staticsService,
            lottoOutput);

    public LottoController getLottoController() {
        return lottoController;
    }

    public RaffleController getRaffleController() {
        return raffleController;
    }

    public StaticsController getStaticsController() {
        return staticsController;
    }
}
