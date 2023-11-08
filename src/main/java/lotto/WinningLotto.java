package lotto;

import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;

import static lotto.Constant.MAX_NUMBER_SIZE;
import static lotto.ErrorMessage.*;
import static lotto.LottoResult.*;
import static lotto.Util.convertStringToInt;
import static lotto.Util.convertStringToIntegerList;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(String numbersStr, String bonusNumberStr) {
        Validator.validate(numbersStr, bonusNumberStr);
        this.numbers = convertStringToIntegerList(numbersStr);
        this.bonusNumber = convertStringToInt(bonusNumberStr);
    }

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;

        Collections.sort(this.numbers);
    }

    public LottoResult getLottoResult(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchingNumbers = (int) lottoNumbers.stream().
                filter(numbers::contains)
                .count();
        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);

        if (matchingNumbers == FIRST.getMatch()) {
            return LottoResult.FIRST;
        } else if (matchingNumbers == SECOND.getMatch() && hasBonusNumber) {
            return LottoResult.SECOND;
        } else if (matchingNumbers == THIRD.getMatch()) {
            return LottoResult.THIRD;
        } else if (matchingNumbers == FOURTH.getMatch()) {
            return LottoResult.FOURTH;
        } else if (matchingNumbers == FIFTH.getMatch()) {
            return LottoResult.FIFTH;
        }

        return null;
    }

    public static class Validator {
        public static void validate(String numbers, String bonusNumber) {
            checkConvertStringToInt(bonusNumber);
            checkValidNumberSize(numbers);
            checkNumberDuplicate(numbers);
            checkBonusDuplicate(numbers, bonusNumber);
        }

        public static void checkConvertStringToInt(String input) {
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(NOT_INT.getMessage());
            }
        }

        public static void checkValidNumberSize(String numberStr) {
            List<Integer> numbers = convertStringToIntegerList(numberStr);
            if (numbers.size() != MAX_NUMBER_SIZE) {
                throw new IllegalArgumentException(INVALID_NUMBER_SIZE.getMessage());
            }
        }

        public static void checkNumberDuplicate(String numberStr) {
            List<Integer> numbers = convertStringToIntegerList(numberStr);
            if (numbers.stream().distinct().count() != 6) {
                throw new IllegalArgumentException(NUMBER_DUPLICATE.getMessage());
            }
        }

        public static void checkBonusDuplicate(String numberStr, String bonusStr) {
            List<Integer> numbers = convertStringToIntegerList(numberStr);
            int bonusNumber = convertStringToInt(bonusStr);
            if (numbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(BONUS_DUPLICATE.getMessage());
            }
        }
    }
}
