package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (!(1 <= num && num <= 45)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : numbers) {
            if (!set.add(num)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void printNumbers() {
        String joinNumbers = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("[" + joinNumbers + "]");
    }

    public Rank checkLottoWinningRank(List<Integer> winningNumbers, Integer bonusNumber) {
        HashSet<Integer> set = new HashSet<>(winningNumbers);
        Integer matchingNumberCount = 0;
        Integer bonusNumberCount = 0;
        for (Integer num : numbers) {
            if (set.contains(num)) {
                matchingNumberCount += 1;
            }
            if (num == bonusNumber) {
                bonusNumberCount += 1;
            }
        }

        return getRank(matchingNumberCount, bonusNumberCount);
    }

    private Rank getRank(Integer matchingNumberCount, Integer bonusNumberCount) {
        if (matchingNumberCount == 6) {
            return Rank.FIRST_PLACE;
        } else if (matchingNumberCount == 5 && bonusNumberCount == 1) {
            return Rank.SECOND_PLACE;
        } else if (matchingNumberCount == 5) {
            return Rank.THIRD_PLACE;
        } else if (matchingNumberCount == 4) {
            return Rank.FOURTH_PLACE;
        } else if (matchingNumberCount == 3) {
            return Rank.FIFTH_PLACE;
        }
        return Rank.OTHER_PLACE;
    }
}
