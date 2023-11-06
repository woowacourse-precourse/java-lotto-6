package lotto.controller;

import lotto.service.Service;
import lotto.validator.Validations;

import java.util.Map;

public class BonusNumberController implements BasicController {
    private final Service service = new Service();
    private final Validations validations = new Validations();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        service.saveBonusNumber((String)model.get("bonusNumber"));
        return null;
    }
}
