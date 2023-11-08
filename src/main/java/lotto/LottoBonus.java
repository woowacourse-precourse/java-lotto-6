package lotto;

import java.util.*;

public class LottoBonus {
    private static final String ERROR_MESSAGE = "[ERROR]";

    protected final int bonus;

    public LottoBonus (int bonus, List<Integer> numbers) {
        validateRange(bonus);
        validateDuplication(bonus, numbers);
        this.bonus = bonus;
    }

    private void validateRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            System.out.println(ERROR_MESSAGE + " 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplication(int bonus, List<Integer> numbers) {
        HashSet<Integer> duplicateCheck = new HashSet<>(numbers);
        duplicateCheck.add(bonus);

        if (duplicateCheck.size() != 7) {
            System.out.println(ERROR_MESSAGE + " 보너스 번호는 로또 번호와 중복이 없어야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
