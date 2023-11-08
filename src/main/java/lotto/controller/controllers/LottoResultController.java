package lotto.controller.controllers;

import lotto.domain.WinningLotto;
import lotto.dto.BuyLottoDto;
import lotto.dto.Dto;
import lotto.dto.LottoResultOutputDto;
import lotto.dto.WinningLottoInputDto;
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
    public void process(Map<String, ? super Dto.Input> inputs, Map<String, ? super Dto.Output> outputs) {
        init(inputs, outputs);
        LottoResultOutputDto lottoResultOutputDto = service.createLottoResultDto();
        viewLottoResult(outputs, lottoResultOutputDto);
    }

    private void viewLottoResult(Map<String, ? super Dto.Output> outputs, LottoResultOutputDto dto) {
        outputs.put(ParameterConfig.LOTTO_RESULT, dto);
        outputView.view(outputs);
    }

    private void init(Map<String, ? super Dto.Input> inputs, Map<String, ? super Dto.Output> outputs) {
        BuyLottoDto.Output buyLottoDto = (BuyLottoDto.Output) outputs.get(ParameterConfig.BUY_PRICE);
        WinningLottoInputDto winningLottoInputDto = (WinningLottoInputDto) inputs.get(ParameterConfig.WINNING_LOTTO);

        WinningLotto winningLotto = new WinningLotto(winningLottoInputDto.getLotto(), winningLottoInputDto.getBonus());
        service = new LottoResultService(winningLotto, buyLottoDto.getBuyLotto());
    }
}
