package lotto.valid;

import static lotto.consts.ErrorMsgConst.ERROR_WINNUMBER_DUPLICATE_SIZE;
import static lotto.consts.ErrorMsgConst.ERROR_WINNUMBER_SIZE;
import static lotto.consts.ErrorMsgConst.ERROR_WINNUMBER_VALUE_RANGE;
import static lotto.consts.LottoConst.LOTTO_MAX_NUMBER;
import static lotto.consts.LottoConst.LOTTO_MIN_NUMBER;
import static lotto.consts.LottoConst.LOTTO_SIZE;
import static lotto.valid.CommonValid.validOnlyNumber;

import java.util.List;
import lotto.util.ConvertStr;

public class WinNumberValid {

    public static List<Integer> validWinNumber(String input) {
        List<String> nums = ConvertStr.splitByComma(input);
        validOnlyNum(nums);
        List<Integer> intNums = ConvertStr.strsToIntegers(nums);
        validLottoNums(intNums);
        return intNums;
    }

    public static void validLottoNums(List<Integer> intNums) {
        validWinNumberSize(intNums);
        validWinNumberDistinctSize(intNums);
        validWinNumberValue(intNums);
    }

    private static void validOnlyNum(List<String> nums) {
        String reg = "^[0-9]*$";
        for (String number : nums) {
            validOnlyNumber(number);
        }
    }

    private static void validWinNumberSize(List<Integer> intNums) {
        if (intNums.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_WINNUMBER_SIZE);
        }
    }

    private static void validWinNumberDistinctSize(List<Integer> intNums) {
        if (intNums.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_WINNUMBER_DUPLICATE_SIZE);
        }
    }

    private static void validWinNumberValue(List<Integer> intNums) {
        if (!intNums.stream().allMatch(num -> num >= LOTTO_MIN_NUMBER && num <= LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_WINNUMBER_VALUE_RANGE);
        }
    }
}