package lotto.service.impl;

import lotto.exception.DifferentUnitFormatException;
import lotto.exception.WrongTypeFormatException;
import lotto.service.ValidateService;

public class ValidateServiceImpl implements ValidateService {
    private static Integer checkIncludeChar(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeFormatException();
        }
    }

    @Override
    public void checkCorrectMoneyInput(String input) {
        Integer money = checkIncludeChar(input);
        if (money % 1000 != 0) {
            throw new DifferentUnitFormatException();
        }
    }
}
