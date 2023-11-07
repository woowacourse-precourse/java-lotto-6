package lotto.controller;

import lotto.service.LotteryService;
import lotto.validator.Validations;

import java.util.Map;

public class BonusNumberController implements BasicController {
    private final LotteryService lotteryService = LotteryService.getInstance();
    private final Validations validations = Validations.getInstance();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        lotteryService.saveBonusNumber((String)model.get("bonusNumber"));
        return null;
    }
}
