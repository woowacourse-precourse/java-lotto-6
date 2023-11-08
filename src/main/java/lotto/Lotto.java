package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

import static lotto.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_COUNT || numbers.stream().distinct().toList().size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개의 정수로 이루어져야 합니다.");
        }
        for (Integer number : numbers) {
            if (number < MIN_NUM || number > MAX_NUM) {
                throw new IllegalArgumentException("로또 번호의 숫자 범위는 1~45 입니다.");
            }
        }
    }

    public Result match(List<Integer> winnerNums, int bonusNum) {
        int matchCount = getMatchCount(winnerNums);
        boolean hitBonusNum = isHitBonusNum(bonusNum);
        return getResult(matchCount, hitBonusNum);
    }

    private int getMatchCount(List<Integer> winnerNums) {
        return (int) numbers.stream()
                .filter(winnerNums::contains)
                .count();
    }

    private boolean isHitBonusNum(int bonusNum) {
        return numbers.contains(bonusNum);
    }

    private Result getResult(int matchCount, boolean hitBonusNum) {
        if (matchCount == Result.FIVE_BONUS.getMatchCount() && hitBonusNum) {
            return Result.FIVE_BONUS;
        }
        if (matchCount == Result.THREE.getMatchCount()) {
            return Result.THREE;
        }
        if (matchCount == Result.FOUR.getMatchCount()) {
            return Result.FOUR;
        }
        if (matchCount == Result.FIVE.getMatchCount()) {
            return Result.FIVE;
        }
        if (matchCount == Result.SIX.getMatchCount()) {
            return Result.SIX;
        }
        return Result.LOSE;
    }
}
