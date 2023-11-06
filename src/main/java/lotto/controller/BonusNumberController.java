package lotto.controller;

import lotto.service.LottteryService;
import lotto.validator.Validations;

import java.util.Map;

public class BonusNumberController implements BasicController {
    private final LottteryService lottteryService = new LottteryService();
    private final Validations validations = new Validations();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        lottteryService.saveBonusNumber((String)model.get("bonusNumber"));
        return null;
    }
}
