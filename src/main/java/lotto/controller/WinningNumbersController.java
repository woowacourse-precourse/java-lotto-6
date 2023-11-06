package lotto.controller;

import lotto.service.LotteryService;

import java.util.Map;

public class WinningNumbersController implements BasicController {
    private final LotteryService lotteryService = LotteryService.getInstance();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        lotteryService.saveLottoNumbers((String) model.get("lottoWinningNumbers"));
        return null;
    }
}
