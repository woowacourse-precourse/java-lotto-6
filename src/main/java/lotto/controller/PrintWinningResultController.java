package lotto.controller;

import lotto.service.LotteryService;

import java.util.List;
import java.util.Map;

public class PrintWinningResultController implements BasicController {
    private final LotteryService lotteryService = LotteryService.getInstance();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        List<String> messages = lotteryService.printWinningResult();
        model.put("messages", messages);
        return null;
    }
}
