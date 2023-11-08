package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final Integer LOTTO_NUMBERS_COUNT = 6;
    private static final Integer MINIMUM_LOTTO_RANGE = 1;
    private static final Integer MAXIMUM_LOTTO_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateHasDuplicate(numbers);
        validateNumberRange(numbers);

        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean isInNumberRange = numbers.stream()
                .allMatch(number ->
                        (number >= MINIMUM_LOTTO_RANGE && number <= MAXIMUM_LOTTO_RANGE));

        if (!isInNumberRange) {
            throw new IllegalArgumentException("[ERROR] 각 로또 번호는 1 에서 45 까지 입력 가능합니다.");
        }
    }


    private void validateHasDuplicate(List<Integer> numbers) {
        boolean hasDuplicate = numbers.size() != Set.copyOf(numbers).size();

        if (hasDuplicate) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private Integer matchWithBonus(Integer bonus) {
        if (numbers.contains(bonus)) {
            return 1;
        }
        return 0;
    }

    private Integer matchWithNumbers(Lotto winLotto) {
        return (int) numbers.stream()
                .filter(winLotto.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        final List<Integer> results = new ArrayList<Integer>(numbers);
        Collections.sort(results);
        return Collections.unmodifiableList(results);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Ranking matchWithWinLotto(WinLotto winLotto) {
        Integer matchNumbers = matchWithNumbers(winLotto);
        Integer matchBonus = matchWithBonus(winLotto.bonus);
        return Ranking.compareRanking(matchNumbers, matchBonus);
    }
}
