package lotto.controller;

import lotto.domain.WinningLotto;
import lotto.dto.BuyLottoDTO;
import lotto.dto.DTO;
import lotto.dto.LottoResultDTO;
import lotto.dto.WinningLottoDTO;
import lotto.service.LottoResultService;
import lotto.view.OutputView;
import lotto.view.ParameterConfig;

import java.util.Map;

public final class LottoResultController implements Controller {
    private final OutputView outputView;

    private LottoResultService service;

    public LottoResultController(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public void process(Map<String, ? super DTO.Input> inputDto, Map<String, ? super DTO.Output> outputDto) {
        init(inputDto, outputDto);
        LottoResultDTO lottoResultDto = service.createLottoResultDto();
        viewLottoResult(outputDto, lottoResultDto);
    }

    private void viewLottoResult(Map<String, ? super DTO.Output> outputs, LottoResultDTO dto) {
        outputs.put(ParameterConfig.LOTTO_RESULT, dto);
        outputView.view(outputs);
    }

    private void init(Map<String, ? super DTO.Input> inputDto, Map<String, ? super DTO.Output> outputDto) {
        BuyLottoDTO.Output buyLottoDto = (BuyLottoDTO.Output) outputDto.get(ParameterConfig.BUY_PRICE);
        WinningLottoDTO winningLottoDto = (WinningLottoDTO) inputDto.get(ParameterConfig.WINNING_LOTTO);

        WinningLotto winningLotto = new WinningLotto(winningLottoDto.getLotto(), winningLottoDto.getBonus());
        service = new LottoResultService(winningLotto, buyLottoDto.getPurchasedLotto());
    }
}
