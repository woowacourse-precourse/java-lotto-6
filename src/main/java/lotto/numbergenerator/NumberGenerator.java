package lotto.numbergenerator;

import static lotto.enums.AmountEnum.MIN_VALUE;
import static lotto.enums.AmountEnum.ZERO_VALUE;
import static lotto.enums.LottoNumberEnum.END_VALUE;
import static lotto.enums.LottoNumberEnum.SIZE;
import static lotto.enums.LottoNumberEnum.START_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.IllegalAmountException;
import lotto.exception.IllegalNullTypeException;
import lotto.exception.IllegalNumberTypeException;

public class NumberGenerator {
    private final static String DELIMITER = ",";
    private final static String NUMBER_REGEX = "\\d+";

    public List<Integer> createRandomUniqueNumber() {
        return Randoms.pickUniqueNumbersInRange(START_VALUE.getValue(), END_VALUE.getValue(), SIZE.getValue());
    }

    public List<Integer> createLottoNumbersFromConsole(String unprocessedNumbers) {
        List<Integer> numbers = new ArrayList<>();
        this.validateIsNull(unprocessedNumbers);
        String[] splitUnprocessedNumber = unprocessedNumbers.split(DELIMITER);
        for (String unprocessedNumber : splitUnprocessedNumber) {
            this.validateNumberType(unprocessedNumber);
            Integer number = Integer.valueOf(unprocessedNumber);
            numbers.add(number);
        }
        return numbers;
    }

    public Integer createAmountFromConsole(String unprocessedAmount) {
        this.validateIsNull(unprocessedAmount);
        this.validateNumberType(unprocessedAmount);
        Integer amount = Integer.valueOf(unprocessedAmount);
        this.validateMinimumAmount(amount);
        return amount;
    }

    private void validateNumberType(String unprocessedNumbers) {
        if (!unprocessedNumbers.matches(NUMBER_REGEX)) {
            throw new IllegalNumberTypeException();
        }
    }

    private void validateMinimumAmount(Integer amount) {

        if (amount % MIN_VALUE.getAmount() != ZERO_VALUE.getAmount()) {
            throw new IllegalAmountException();
        }
    }

    private void validateIsNull(String unprocessedNumbers) {
        if (unprocessedNumbers == null) {
            throw new IllegalNullTypeException();
        }
    }
}
