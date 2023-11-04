package domain;

import camp.nextstep.edu.missionutils.Console;
import exception.LottoException;

import java.util.Collections;
import java.util.List;

public class BonusNumber {

    public int bonusNumberService(List<Integer> winningNumbers) {
        String inputValue = Console.readLine();
        int bonusNumber = Integer.parseInt(inputValue);

        validateNumberRange(bonusNumber);
        validateNumberUnique(bonusNumber, winningNumbers);

        return bonusNumber;
    }


    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new LottoException(LottoException.ERROR_OUT_OF_RANGE_NUMBER);
        }
    }

    private static void validateNumberUnique(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new LottoException(LottoException.ERROR_DUPLICATE_NUMBERS);
        }
    }
}
