package lotto.util.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidate {

    public static int validateInputFormat(String input) {
        int parseIntInputValue;
        try {
            parseIntInputValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        return parseIntInputValue;
    }

    public static void validateThousandUnitInputFormat(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static void validateUniqueInputLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> checkingUniqueNumbers = new HashSet<>(lottoNumbers);
        if (checkingUniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력한 로또 당첨 번호 중 중복된 숫자가 존재합니다.");
        }
    }

    public static void validateRangeInputLottoNumbers(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            if (isValidNumberRange(lottoNumber)) {
                throw new IllegalArgumentException("[ERROR] 입력한 로또 당첨 번호는 1 ~ 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateRangeInputLottoBonusNumber(int bonusNumber) {
        if (isValidNumberRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력한 로또 당첨 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateUniqueInputLottoBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 번호는 로또 당첨 번호와 중복된 숫자가 존재합니다.");
        }
    }

    static public boolean isValidNumberRange(int number) {
        return 1 <= number && number <= 45;
    }
}
