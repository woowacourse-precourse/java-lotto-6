package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lucky {

    private static final String DUPLICATE_ERROR = "[ERROR] 중복되는 숫자는 불가능합니다.";
    private static final String SIZE_ERROR = "[ERROR] 6자리의 당첨 번호를 입력해야 합니다.";
    private static final String DUPLICATE_WITH_BONUS = "[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.";
    private static final String RANGE_ERROR = "[ERROR] 1에서 45 사이의 숫자를 입력하세요.";
    private static final int CORRECT_5 = 5;
    private static final int CORRECT_3 = 3;
    private static final int NO_REWARD = 0;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lucky;
    private final int bonus;

    public Lucky(List<Integer> lucky, int bonus) {
        validateDuplication(lucky);
        validateSize(lucky);
        lucky.stream().forEach(n -> validateRange(n));
        validateBonus(lucky, bonus);
        validateRange(bonus);
        this.lucky = lucky;
        this.bonus = bonus;
    }

    public Rank checkWinning(Lotto lotto) {
        Comparator comparator = new Comparator();
        boolean bonus = false;
        int count = comparator.compare(lotto.getNumbers(), lucky);
        if (count == CORRECT_5) {
            bonus = checkBonus(lotto.getNumbers());
        }
        if (count < CORRECT_3) {
            count = NO_REWARD;
        }
        return Rank.valueOfCount(count, bonus);
    }

    private boolean checkBonus(List<Integer> lotto) {
        return lotto.contains(bonus);
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    private void validateBonus(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_WITH_BONUS);
        }
    }

    private void validateRange(int n) {
        if (n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
}
