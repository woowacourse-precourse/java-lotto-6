package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.constant.NumberConstant.*;

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
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberInRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE)
            throw new IllegalArgumentException();
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer n : numbers)
            if (!uniqueNumbers.add(n))
                throw new IllegalArgumentException();
    }

    public static void validateNumberInRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(n -> n < LOTTO_NUMBER_START | n > LOTTO_NUMBER_END))
            throw new IllegalArgumentException();
    }


    public static List<Lotto> createRandomLottos(int ticketNum) {
        return IntStream.range(0, ticketNum)
                .mapToObj(i -> generateRandomLotto())
                .collect(Collectors.toList());
    }

    private static Lotto generateRandomLotto() {
        return new Lotto(pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_SIZE));
    }

    public static MatchResult match(Lotto randomLotto, Lotto winLotto, int bonusNum) {
        List<Integer> randomNumbers = randomLotto.getNumbers();
        List<Integer> winNumbers = winLotto.getNumbers();

        int matchCount = (int) randomNumbers.stream()
                .filter(winNumbers::contains)
                .count();

        if (matchCount == BONUS_MATCH_COUNT && isBonusMatch(randomNumbers, bonusNum)) {
            return MatchResult.BONUS;
        }

        return MatchResult.fromCount(matchCount);
    }

    private static boolean isBonusMatch(List<Integer> randomNumbers, int bonusNum) {
        return randomNumbers.contains(bonusNum);
    }
}
