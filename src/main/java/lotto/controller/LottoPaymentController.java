package lotto.controller;

import lotto.service.Service;
import lotto.validator.Validations;

import java.util.Map;

public class LottoPaymentController implements BasicController{
    private final Service service = new Service();

    @Override
    public String handle(Map<String, Object> model) throws IllegalArgumentException{
        service.lottoPayment((String) model.get("desiredPurchaseAmount"));
        return null;
    }
}
