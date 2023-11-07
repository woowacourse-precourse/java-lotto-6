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
    public void process(Map<String, ? super DTO.Input> inputs,
                        Map<String, ? super DTO.Output> outputs) {
        try {
            Long price = getBuyLottoPrice(inputs, outputs);
            viewBuyLottoNumbers(outputs, price);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            process(inputs, outputs);
        }
    }

    private void viewBuyLottoNumbers(Map<String, ? super DTO.Output> outputs, Long price) {
        BuyLottoDTO.Output purchasedLottoDTO = service.getPurchasedLottoDTO(price);
        outputs.put(ParameterConfig.BUY_PRICE, purchasedLottoDTO);
        outputView.view(outputs);
    }

    private Long getBuyLottoPrice(Map<String, ? super DTO.Input> inputs,
                                  Map<String, ? super DTO.Output> outputs) {

        inputs.put(ParameterConfig.BUY_PRICE, new BuyLottoDTO.Input());
        outputView.view(outputs);
        inputView.read(inputs);
        return ((BuyLottoDTO.Input) inputs.get(ParameterConfig.BUY_PRICE)).getBuyPrice();
    }
}
