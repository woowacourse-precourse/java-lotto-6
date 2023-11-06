package lotto.core.numbergenerator;

import static lotto.core.enums.LottoNumberEnum.END_VALUE;
import static lotto.core.enums.LottoNumberEnum.SIZE;
import static lotto.core.enums.LottoNumberEnum.START_VALUE;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import lotto.core.enums.AmountEnum;
import lotto.core.exception.IllegalAmountException;
import lotto.core.exception.IllegalOverValueException;
import lotto.core.exception.IllegalNullTypeException;
import lotto.core.exception.IllegalNumberTypeException;
import lotto.core.exception.IllegalRangeException;
import lotto.core.lotto.LottoTicket;
import lotto.core.lotto.WinningNumbers;

public class NumberGenerator {

    private final static String DELIMITER = ",";
    private final static String NUMBER_REGEX = "\\d+";


    public List<Integer> createRandomUniqueNumber() {
        return Randoms.pickUniqueNumbersInRange(START_VALUE.getValue(), END_VALUE.getValue(), SIZE.getValue());
    }

    public WinningNumbers createWinningNumbersFromConsole(String unprocessedNumbers) {
        this.validateIsNull(unprocessedNumbers);
        List<Integer> numbers = new ArrayList<>();
        LottoTicket winningNumber = createWinningNumber(unprocessedNumbers, numbers);
        return new WinningNumbers(winningNumber);
    }

    private LottoTicket createWinningNumber(String unprocessedNumbers, List<Integer> numbers) {
        String[] splitUnprocessedNumber = unprocessedNumbers.split(DELIMITER);
        for (String unprocessedNumber : splitUnprocessedNumber) {
            this.validateNumberType(unprocessedNumber);
            this.validateNumberRange(unprocessedNumber);
            Integer number = Integer.valueOf(unprocessedNumber);
            numbers.add(number);
        }
        return new LottoTicket(numbers);
    }

    public Integer createBonusNumberFromConsole(String unprocessedNumbers) {
        commonValidate(unprocessedNumbers);
        Integer bonusNumber = Integer.valueOf(unprocessedNumbers);
        validateIsSingleNumber(bonusNumber);
        return bonusNumber;
    }

    public Integer createAmountToQuantity(String unprocessedAmount) {
        Integer amountFromConsole = this.createAmountFromConsole(unprocessedAmount);
        return this.createAmountToQuantity(amountFromConsole);
    }

    private Integer createAmountFromConsole(String unprocessedAmount) {
        commonValidate(unprocessedAmount);
        this.validateNumberRange(unprocessedAmount);
        Integer amount = Integer.valueOf(unprocessedAmount);
        this.validateMinimumAmount(amount);
        return amount;

    }

    private Integer createAmountToQuantity(Integer amount) {
        return amount / AmountEnum.MIN_VALUE.getAmount();
    }

    private void commonValidate(String unprocessedNumbers) {
        this.validateIsNull(unprocessedNumbers);
        this.validateNumberType(unprocessedNumbers);
    }

    private void validateNumberType(String unprocessedNumbers) {
        if (!unprocessedNumbers.matches(NUMBER_REGEX)) {
            throw new IllegalNumberTypeException();
        }
    }

    private void validateMinimumAmount(Integer amount) {
        if (amount % AmountEnum.MIN_VALUE.getAmount() != AmountEnum.ZERO_VALUE.getAmount()) {
            throw new IllegalAmountException();
        }
    }

    private void validateIsNull(String unprocessedNumbers) {
        if (unprocessedNumbers == null) {
            throw new IllegalNullTypeException();
        }
    }

    private void validateIsSingleNumber(Integer bonusNumber) {
        if (bonusNumber < START_VALUE.getValue() || bonusNumber > END_VALUE.getValue()) {
            throw new IllegalOverValueException();
        }
    }

    private void validateNumberRange(String unprocessedNumbers) {
        try {
            Integer.parseInt(unprocessedNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalRangeException();
        }
    }

}
