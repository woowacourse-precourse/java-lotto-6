package lotto.validate;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.excpetion.DivedException;
import lotto.excpetion.DuplicatedException;
import lotto.excpetion.NotInRageException;
import lotto.excpetion.SizeException;

import java.util.List;

import static lotto.utils.NumberConstant.PRICE_UNIT;

public class LottoValidator {
    public static void lottoValidate(List<Integer> numbers) {
        validate(numbers);
        isInRange(numbers);
        isDuplicated(numbers);
    }
    private static void isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45)
                throw new NotInRageException();
        }
    }

    private static void isInRange(BonusNumber bonusNumber) {
        int number = bonusNumber.getBonusNumber();
        if (number < 1 || number > 45)
            throw new NotInRageException();
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new SizeException();
        }
    }

    private static void isDuplicated(List<Integer> numbers) {
        List<Integer> distinctNumbers =
                numbers.stream()
                        .distinct().toList();
        if (distinctNumbers.size() != numbers.size())
            throw new DuplicatedException();
    }


    public static void bonusNumberValidate(Lotto lotto, BonusNumber bonusNumber) {
        isInRange(bonusNumber);
        bonusNumberDuplicated(lotto, bonusNumber);
    }

    private static void bonusNumberDuplicated(Lotto lotto, BonusNumber bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonusNumber.getBonusNumber()))
            throw new DuplicatedException();
    }

    public static void isDivedWithThousand(int price) {
        if (!((price % PRICE_UNIT.getValue()) == 0)) {
            throw new DivedException();
        }
    }
}
