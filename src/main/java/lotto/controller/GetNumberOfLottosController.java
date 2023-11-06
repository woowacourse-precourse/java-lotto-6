package lotto.controller;

import lotto.service.LotteryService;

import java.util.List;
import java.util.Map;

public class GetNumberOfLottosController implements BasicController {
    private final LotteryService lotteryService = LotteryService.getInstance();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        List<String> printMessage = lotteryService.getNumberOfLottos();

        model.put("messages", printMessage);
        return "printLottos";
    }
}
