package lotto.controller;

import lotto.dto.LottoDto;
import lotto.model.repository.LottoRepository;
import lotto.model.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService service;

    public LottoController() {
        this.service = new LottoService(new LottoRepository());
    }

    public void run() {
        LottoDto lottoDto = new LottoDto();

        InputController.inputLottoPurchaseAmount(lottoDto);
        service.createLottos(lottoDto);

        OutputView.outputAllLottoNumbers(service.getLottos());
        InputController.inputWinningNumbers(lottoDto);
        InputController.inputBonusNumber(lottoDto);

        service.createGame(lottoDto);

        service.compareLottosWithWinningNumbers();
        OutputView.outputResult(service.getResult());
        OutputView.outputProfitRate(service.getProfitRate());
    }
}
