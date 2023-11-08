package lotto.util;

import lotto.domain.Lotto;
import lotto.exception.ExceptionEnum;
import lotto.exception.LottoGameException;

import java.util.List;

public class Validate {
    public static Long checkPurchaseAmountValidate(String purchaseAmount) {
        Long amount = checkLongValidate(purchaseAmount);
        checkDividedValidate(amount);
        return amount;
    }

    public static Integer checkWinningNumberValidate(String number) {
        int num = checkIntegerAndSpace(number);
        checkLottoRange(num);
        return num;
    }

    public static void checkDuplicated(List<String> numbers, List<Integer> lotto) {
        if (numbers.size() != lotto.stream().distinct().count()) {
            throw new LottoGameException(ExceptionEnum.CONTAIN_DUPLICATE_NUMBER_EXCEPTION);
        }
    }

    public static int checkBonusNumberValidate(String bonusNumber, Lotto lotto) {
        int result = checkIntegerAndSpace(bonusNumber);
        checkDuplicateWinningNumber(result, lotto);
        return result;
    }

    private static Long checkLongValidate(String purchaseAmount) {
        try {
            return Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new LottoGameException(ExceptionEnum.NOT_NUMBER_EXCEPTION);
        }
    }

    private static void checkDividedValidate(Long amount) {
        if (amount % 1000 != 0) {
            throw new LottoGameException(ExceptionEnum.NOT_DIVIDED_EXCEPTION);
        }
    }

    public static Integer checkIntegerAndSpace(String number) {
        try {
            checkSpace(number);
            int num = Integer.parseInt(number);
            return num;
        } catch (NumberFormatException e) {
            throw new LottoGameException(ExceptionEnum.NOT_NUMBER_EXCEPTION);
        }
    }
    private static void checkLottoRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new LottoGameException(ExceptionEnum.NOT_IN_RANGE_EXCEPTION);
        }
    }

    private static void checkSpace(String number) {
        if (number.contains(" ")) {
            throw new LottoGameException(ExceptionEnum.CONTAIN_EMPTY_SPACE_EXCEPTION);
        }
    }

    private static void checkDuplicateWinningNumber(int bonusNumber, Lotto lotto) {
        for (int num : lotto.getNumbers()) {
            if (bonusNumber == num) {
                throw new LottoGameException(ExceptionEnum.CONTAIN_DUPLICATE_BONUS_NUMBER_EXCEPTION);
            }
        }
    }

}
