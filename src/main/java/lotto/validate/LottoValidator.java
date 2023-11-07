package lotto.validate;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.excpetion.DivedException;
import lotto.excpetion.DuplicatedException;
import lotto.excpetion.NotInRageException;
import lotto.excpetion.SizeException;

import java.util.List;

public class LottoValidator {
    public static void lottoValidate(Lotto lotto) {
        validate(lotto);
        isInRange(lotto);
        isDuplicated(lotto);
    }
    private static void isInRange(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
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

    private static void validate(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.size() != 6) {
            throw new SizeException();
        }
    }

    public static void bonusNumberValidate(Lotto lotto, BonusNumber bonusNumber) {
        isInRange(bonusNumber);
        bonusNumberDuplicated(lotto, bonusNumber);
    }

    private static void isDuplicated(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> distinctNumbers =
                numbers.stream()
                        .distinct().toList();
        if (distinctNumbers.size() != numbers.size())
            throw new DuplicatedException();
    }

    private static void bonusNumberDuplicated(Lotto lotto, BonusNumber bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonusNumber.getBonusNumber()))
            throw new DuplicatedException();
    }

    public static void isDivedWithThousand(int price) {
        if (!(price % 1000 == 0)) {
            throw new DivedException();
        }
    }
}
