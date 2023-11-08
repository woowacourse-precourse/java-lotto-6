package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers.stream().distinct().toList().size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto create() {
        List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNums);
    }

    public Result match(List<Integer> winnerNums, int bonusNum) {
        int matchCount = getMatchCount(winnerNums);
        boolean hitBonusNum = isHitBonusNum(bonusNum);
        return getResult(matchCount, hitBonusNum);
    }

    private int getMatchCount(List<Integer> winnerNums) {
        int matchCount = 0;
        for (Integer number : numbers) {
            for (Integer winnerNum : winnerNums) {
                if (number.equals(winnerNum)) {
                    matchCount++;
                }
            }
        }
        return matchCount;
    }

    private boolean isHitBonusNum(int bonusNum) {
        boolean hitBonusNum = false;
        for (Integer number : numbers) {
            if (number == bonusNum) {
                hitBonusNum = true;
                break;
            }
        }
        return hitBonusNum;
    }

    private Result getResult(int matchCount, boolean hitBonusNum) {
        if (matchCount == 5 && hitBonusNum) {
            return Result.FIVE_BONUS;
        }
        if (matchCount == 3) {
            return Result.THREE;
        }
        if (matchCount == 4) {
            return Result.FOUR;
        }
        if (matchCount == 5) {
            return Result.FIVE;
        }
        if (matchCount == 6) {
            return Result.SIX;
        }
        return Result.LOSE;
    }
}
