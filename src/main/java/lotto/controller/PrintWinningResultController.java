package lotto.controller;

import lotto.service.LottteryService;

import java.util.List;
import java.util.Map;

public class PrintWinningResultController implements BasicController {
    private final LottteryService lottteryService = new LottteryService();


    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        List<String> messages = lottteryService.printWinningResult();
        model.put("messages", messages);
        return null;
    }
}
