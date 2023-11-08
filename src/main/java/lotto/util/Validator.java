package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.enumeration.ExceptionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Validator {
    public static boolean validateAmount(String input) {
        return validateAmountType(input) &&
                validateAmountRange(Integer.parseInt(input)) &&
                validateAmountMultiple(Integer.parseInt(input));
    }

    public static boolean validateAmountType(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ExceptionType.INVALID_INPUT_TYPE.getMessage());
            return false;
        }
    }

    public static boolean validateAmountRange(int input) {
        try {
            if (input > 2000000000 || input < 1000) { // limit 상수처리
                throw new InputMismatchException(ExceptionType.EXCEED_AMOUNT_LIMIT.getMessage());
            }
            return true;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateAmountMultiple(int amount) {
        try {
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException(ExceptionType.AMOUNT_NOT_MULTIPLE_1000.getMessage());
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateLotto(String input) {
        List<Integer> nums;
        try {
            validateLottoComma(input);
            nums = validateLottoFormat(input);
            validateLottoLength(nums);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionType.INVALID_LOTTO_FORMAT.getMessage());
            return false;
        }

        try {
            validateDuplicateNums(nums);
            validateNumsRange(nums);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void validateLottoLength(List<Integer> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoComma(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new NumberFormatException();
        }
    }

    public static List<Integer> validateLottoFormat(String input) throws NumberFormatException {
        String[] inputArray = input.split(",");
        List<Integer> nums = new ArrayList<>();
        for (String str : inputArray) {
            nums.add(Integer.parseInt(str.replaceAll("\\s", "")));
        }
        return nums;
    }

    public static void validateDuplicateNums(List<Integer> nums) {
        if (nums.stream().distinct().count() < 6) {
            throw new IllegalArgumentException(ExceptionType.DUPLICATE_LOTTO_NUMS.getMessage());
        }
    }

    public static void validateNumsRange(List<Integer> nums) {
        for (int num : nums) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ExceptionType.EXCEED_LOTTO_RANGE.getMessage());
            }
        }
    }

    public static boolean validateBonus(String input) {
        if (validateBonusType(input) &&
                validateBonusRange(Integer.parseInt(input))) {
            return true;
        }
        return false;
    }

    public static boolean validateBonusType(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ExceptionType.INVALID_INPUT_TYPE.getMessage());
            return false;
        }
    }

    public static boolean validateBonusRange(int input) {
        try {
            if(input < 1 || input > 45) {
                throw new IllegalArgumentException(ExceptionType.EXCEED_BONUS_RANGE.getMessage());
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateWinningLotto(Lotto lotto, int bonus) {
        try {
            if(lotto.getNumbers()
                    .contains(bonus)) {
                throw new IllegalArgumentException(ExceptionType.DUPLICATE_BONUS_LOTTO.getMessage());
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
