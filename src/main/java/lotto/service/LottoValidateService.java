package lotto.service;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.validator.LottoValidator;

public class LottoValidateService {
    public boolean validate(List<String> list) {
        try {
            LottoValidator.isAllNumeric(list);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_NUMERIC.getMessage());
            return false;
        }
        return true;
    }
}
