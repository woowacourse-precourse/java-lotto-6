package lotto.controller;

import lotto.service.LottteryService;

import java.util.Map;

public class WinningNumbersController implements BasicController {
    private final LottteryService lottteryService = new LottteryService();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        lottteryService.saveLottoNumbers((String) model.get("lottoWinningNumbers"));
        return null;
    }
}
