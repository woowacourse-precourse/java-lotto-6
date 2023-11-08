package lotto.Validator;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨번호는 ";
    private static final int LOTTO_SIZE = 6;

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    private static boolean rangeBetweenMinToMax(List<Integer> numbers) {
        for (int index = 0; index < numbers.size(); index++) {
            int number = numbers.get(index);
            if (number < LOTTO_MIN || number > LOTTO_MAX) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>();
        for (int index = 0; index < numbers.size(); index++) {
            int number = numbers.get(index);
            if (!duplicateCheck.add(number)) {
                return false;
            }
        }
        return true;
    }

    public static void validateLottoNumbers(List<Integer> numbers) {

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_SIZE + "개이어야 합니다.");
        }

        if (!hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "중복되지 않는 숫자들로 구성되어있어야 합니다.");
        }

        if (!rangeBetweenMinToMax(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_MIN + "이상 " + LOTTO_MAX + "인 숫자들로 구성되어있어야 합니다.");
        }
    }

}
