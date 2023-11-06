package lotto.validator;

import java.util.List;

public class Validator {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PRISE = 1000;
    private static final int PROPER_REMAINDER = 0;

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다. 쉼표(,)로 구분하여 입력해주세요.");
        }
    }

    public static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(Validator::range)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 숫자여야 합니다.");
        }
    }

    // LOTTO_PRISE를 한 곳에서 관리하기 위해 리턴 값 설정함
    public static int validateUnit(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRISE != PROPER_REMAINDER) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
        return purchaseAmount / LOTTO_PRISE;
    }

    private static boolean range(Integer num) {
        return num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER;
    }
}
