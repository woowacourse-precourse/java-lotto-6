package lotto.controller;

import lotto.service.LottteryService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.enums.GuideMessage.INFORM_PURCHASED_LOTTOS_NUMBERS_MESSAGE;

public class GetNumberOfLottosController implements BasicController {
    private final LottteryService lottteryService = new LottteryService();


    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        List<String> printMessage = lottteryService.getNumberOfLottos();

        model.put("messages", printMessage);
        return "printLottos";
    }
}
