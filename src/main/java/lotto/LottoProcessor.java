package lotto;

import lotto.Controller.LottoController;
import lotto.Model.Service.LottoService;
import lotto.Model.Util.LottoUtil;

public class LottoProcessor {
    private final LottoUtil lottoUtil = new LottoUtil();
    private final LottoService lottoService = new LottoService(lottoUtil);
    private final LottoController lottoController = new LottoController(lottoService);

    public LottoController getLottoController() {
        return lottoController;
    }
}
