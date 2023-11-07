package lotto.controller;

import lotto.dto.BuyLottoDTO;
import lotto.dto.DTO;
import lotto.service.LottoBuyService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ParameterConfig;

import java.util.Map;

public class LottoBuyController implements Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoBuyService service;

    public LottoBuyController(InputView inputView, OutputView outputView, LottoBuyService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    @Override
    public void process(Map<String, ? super DTO.Input> inputDto,
                        Map<String, ? super DTO.Output> outputDto) {
        inputDto.put(ParameterConfig.BUY_PRICE, service.getBuyLottoInputDTO());
        getLottoBuyPrice(inputDto, outputDto);
    }

    private void getLottoBuyPrice(Map<String, ? super DTO.Input> inputDto,
                                  Map<String, ? super DTO.Output> outputDto) {

        outputView.view(outputDto);
        inputView.read(inputDto);
        BuyLottoDTO.Input input = (BuyLottoDTO.Input) inputDto.get(ParameterConfig.BUY_PRICE);
        BuyLottoDTO.Output purchasedLottoDTO = service.getPurchasedLottoDTO(input.getBuyPrice());
        outputDto.put(ParameterConfig.BUY_PRICE, purchasedLottoDTO);
        outputView.view(outputDto);


    }
}
