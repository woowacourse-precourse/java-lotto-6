package lotto.Validator;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.OutputService;

public class LottoValidator {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    public static int getLottoSize() {
        return LOTTO_SIZE;
    }

    private static boolean rangeBetweenMinToMax(List<Integer> numbers) {

        for (Integer number :
                numbers) {
            if (number < LOTTO_MIN || number > LOTTO_MAX) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicate(List<Integer> numbers) {

        Set<Integer> duplicateCheck = new HashSet<>(numbers);
        if (duplicateCheck.size() != LOTTO_SIZE) {
            return false;
        }
        return true;
    }

    public static void validateLottoNumbers(List<Integer> numbers) {

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는" + LOTTO_SIZE + "개이어야 합니다.");
        }

        if (!hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않는 숫자들로 구성되어있어야 합니다.");
        }

        if (!rangeBetweenMinToMax(numbers)) {
            throw new IllegalArgumentException(
                    "로또 번호는" + LOTTO_MIN + "이상 " + LOTTO_MAX + "인 숫자들로 구성되어있어야 합니다.");
        }
    }

}
