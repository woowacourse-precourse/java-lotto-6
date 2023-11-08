package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현



    public static Lotto create() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public Rank calculateRank(List<Integer> drawNumbers, Integer bonusNumber) {
        Integer matchBallCount = (int) numbers.stream()
                .filter(drawNumbers::contains)
                .count();

        Boolean isMatchBonus = numbers.contains(bonusNumber);

        return Rank.getRankByMatchBallCount(matchBallCount, isMatchBonus);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
