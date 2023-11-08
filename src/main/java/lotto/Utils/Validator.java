package lotto.Utils;

import java.util.List;
import java.util.Set;

import static lotto.Utils.LottoConstantNumbers.*;

public class Validator {
    private static final String error = "[ERROR]";

    //입력 값이 있는지 확인
    public static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(error + "입력값이 없습니다.");
        }
    }

    //숫자 입력 갯수 확인
    public static void validateNumberCount(String input) {
        String[] numbersStr = input.split(",");
        if (numbersStr.length != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(error + "로또 번호는 6개여야 합니다.");
        }
    }

    // 숫자가 1에서 45 사이인지 확인
    public static void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER.getValue() || number > MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(error + "로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이여야 합니다: " + number);
        }
    }
    //여러 개의 숫자가 들어왔을 때 1에서 45 사이인지 확인
    public static void validateNumbersRange(String[] input) {
        for (String numberStr : input) {
            int number = Integer.parseInt(numberStr.trim());
            validateNumberRange(number);
        }
    }
    // 보너스 번호 입력 검증을 위해 입력이 숫자인지 확인
    public static void validateBonusNumberFormat(String input) {
        if (!input.trim().matches("\\d+")) {
            throw new IllegalArgumentException("수를 입력하셔야 합니다.");
        }
    }

    // 주어진 번호가 로또 번호 리스트에 중복되는지 확인
    public static void validateBonusNumberDuplicate(int number, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(number)) {
            throw new IllegalArgumentException(error + "기존 로또 번호와 보너스 번호가 중복됩니다.");
        }
    }

    public static void validateLottoNumbersDuplicate(int number, Set<Integer> numbersSet) {
        if (!numbersSet.add(number)) {
            throw new IllegalArgumentException(error + "중복된 번호가 있습니다: " + number);
        }
    }

    public static void moneyValidator(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(error + "1000원 단위의 금액만 입력가능 합니다.");
        }
    }
}
