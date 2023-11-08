package lotto.service.impl;

import static lotto.utils.CalculationConstants.COMMAS_NUMBERS;
import static lotto.utils.CalculationConstants.REMAINS;
import static lotto.utils.LottoConstants.LOTTO_NUMBERS;
import static lotto.utils.LottoConstants.LOTTO_TICKET_PURCHASE_AMOUNT;

import java.util.Arrays;
import java.util.List;
import lotto.exception.IllegalCommasFormatException;
import lotto.exception.IllegalInputException;
import lotto.exception.IllegalTypeFormatException;
import lotto.service.ValidateService;
import lotto.utils.CharConstants;
import lotto.utils.LabelConstants;

public class ValidateServiceImpl implements ValidateService {
    private void checkBlankInput(String input) {
        LabelConstants blank = LabelConstants.BLANK;
        if (input.equals(blank.getValue())) {
            throw new IllegalInputException();
        }
    }

    private void checkCorrectCommas(String input, List<String> inputStream) {
        long commasCount = countCommas(input);
        if (commasCount != COMMAS_NUMBERS.getValue() || inputStream.size() != LOTTO_NUMBERS.getValue()) {
            throw new IllegalCommasFormatException();
        }
    }

    private long countCommas(String input) {
        CharConstants commas = CharConstants.COMMAS;
        return input.chars().filter(ch -> ch == commas.getValue()).count();
    }

    public Integer checkIncludeChar(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalTypeFormatException();
        }
    }

    @Override
    public void checkCorrectMoney(String input) {
        Integer money = checkIncludeChar(input);
        if (!isThousandUnit(money) || !isNaturalNumber(money)) {
            throw new IllegalTypeFormatException();
        }
    }

    private boolean isNaturalNumber(Integer money) {
        return money > 0;
    }

    private boolean isThousandUnit(Integer money) {
        return money % LOTTO_TICKET_PURCHASE_AMOUNT.getValue() == REMAINS.getValue();
    }

    @Override
    public List<Integer> checkCorrectWinnerNumbers(String input) {
        checkBlankInput(input);
        LabelConstants commas = LabelConstants.COMMAS;
        List<String> inputStream = Arrays.asList(input.split(commas.getValue()));
        checkCorrectCommas(input, inputStream);
        try {
            return inputStream.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalTypeFormatException();
        }
    }
}
