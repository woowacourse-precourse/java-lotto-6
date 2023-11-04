package lotto.valid;

import static lotto.consts.LottoConst.LOTTO_MAX_NUMBER;
import static lotto.consts.LottoConst.LOTTO_MIN_NUMBER;
import static lotto.consts.LottoConst.LOTTO_SIZE;

import java.util.List;
import lotto.util.ConvertStr;

public class WinNumberValid {

    public static List<Integer> validWinNumber(String input) {
        List<String> nums = ConvertStr.splitByComma(input);
        validOnlyNum(nums);
        List<Integer> intNums = ConvertStr.strListToIntList(nums);
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
            if (!number.matches(reg)) {
                throw new IllegalArgumentException("[ERROR] ,로 구별된 문자들은 숫자만 입력 가능합니다.");
            }
        }
    }

    private static void validWinNumberSize(List<Integer> intNums) {
        if (intNums.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다.");
        }
    }

    private static void validWinNumberDistinctSize(List<Integer> intNums) {
        if (intNums.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 6개 입력해야 합니다.");
        }
    }

    private static void validWinNumberValue(List<Integer> intNums) {
        if (!intNums.stream().allMatch(num -> num >= LOTTO_MIN_NUMBER && num <= LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 모든 숫자는 1과 45 사이여야 합니다.");
        }
    }
}