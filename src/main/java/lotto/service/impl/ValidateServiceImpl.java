package lotto.service.impl;

import java.util.Arrays;
import java.util.List;
import lotto.exception.WrongBlankException;
import lotto.exception.WrongCommasFormatException;
import lotto.exception.WrongTypeFormatException;
import lotto.service.ValidateService;
import lotto.utils.CharUnit;
import lotto.utils.StringUnit;
import lotto.utils.ValueUnit;

public class ValidateServiceImpl implements ValidateService {
    private void checkBlankInput(String input) {
        StringUnit blank = StringUnit.BLANK;
        if (input.equals(blank.getValue())) {
            throw new WrongBlankException();
        }
    }

    private void checkCorrectCommas(String input, List<String> inputStream) {
        long commasCount = countCommas(input);
        ValueUnit commasNumbers = ValueUnit.COMMAS_NUMBERS;
        ValueUnit lottoNumbers = ValueUnit.LOTTO_NUMBERS;
        if (commasCount != commasNumbers.getValue() || inputStream.size() != lottoNumbers.getValue()) {
            throw new WrongCommasFormatException();
        }
    }

    private long countCommas(String input) {
        CharUnit commas = CharUnit.COMMAS;
        return input.chars().filter(ch -> ch == commas.getValue()).count();
    }

    public Integer checkIncludeChar(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeFormatException();
        }
    }

    @Override
    public void checkCorrectMoney(String input) {
        Integer money = checkIncludeChar(input);
        ValueUnit lottoTicketPurchaseAmount = ValueUnit.LOTTO_TICKET_PURCHASE_AMOUNT;
        ValueUnit remains = ValueUnit.REMAINS;
        if (money % lottoTicketPurchaseAmount.getValue() != remains.getValue()) {
            throw new WrongTypeFormatException();
        }
    }

    @Override
    public List<Integer> checkCorrectWinnerNumbers(String input) {
        checkBlankInput(input);
        StringUnit commas = StringUnit.COMMAS;
        List<String> inputStream = Arrays.asList(input.split(commas.getValue()));
        checkCorrectCommas(input, inputStream);
        try {
            return inputStream.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException numberFormatException) {
            throw new WrongTypeFormatException();
        }
    }
}
