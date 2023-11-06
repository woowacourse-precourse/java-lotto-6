package lotto.controller;

import lotto.service.Service;
import lotto.validator.Validations;

import java.util.List;
import java.util.Map;

public class WinningNumbersController implements BasicController {
    private final Service service = new Service();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException {
        service.saveLottoNumbers((String) model.get("lottoWinningNumbers"));
        return null;
    }
}
