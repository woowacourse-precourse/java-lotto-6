package lotto.controller.controllers;

import lotto.dto.BuyLottoDto;
import lotto.dto.Dto;
import lotto.service.LottoBuyService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ParameterConfig;

import java.util.Map;

public final class LottoBuyController implements Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoBuyService service;

    public LottoBuyController(InputView inputView, OutputView outputView, LottoBuyService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    @Override
    public void process(Map<String, ? super Dto.Input> inputs,
                        Map<String, ? super Dto.Output> outputs) {
        try {
            Long price = getBuyLottoPrice(inputs, outputs);
            viewBuyLottoNumbers(outputs, price);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            process(inputs, outputs);
        }
    }

    private void viewBuyLottoNumbers(Map<String, ? super Dto.Output> outputs, Long price) {
        BuyLottoDto.Output buyLottoDto = service.getBuyLottoDto(price);
        outputs.put(ParameterConfig.BUY_PRICE, buyLottoDto);
        outputView.view(outputs);
    }

    private Long getBuyLottoPrice(Map<String, ? super Dto.Input> inputs,
                                  Map<String, ? super Dto.Output> outputs) {

        inputs.put(ParameterConfig.BUY_PRICE, new BuyLottoDto.Input());
        outputView.view(outputs);
        inputView.read(inputs);
        return ((BuyLottoDto.Input) inputs.get(ParameterConfig.BUY_PRICE)).getBuyPrice();
    }
}
