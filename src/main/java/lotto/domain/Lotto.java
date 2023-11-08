package lotto.domain;

import java.sql.Array;
import java.util.*;

public class Lotto {

    private static final Integer LOTTO_NUMBERS_COUNT = 6;
    private static final Integer MINIMUM_LOTTO_RANGE = 1;
    private static final Integer MAXIMUM_LOTTO_RANGE = 45;

    // TODO: 인스턴스 변수 추가 불가 X.
    // TODO: 패키지 변경 가능 O.
    // TODO: 접근제한자 변경 불가 X.
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateHasDuplicate(numbers);
        validateNumberRange(numbers);

        this.numbers = numbers;
    }

    // TODO: 접근제한자 private 변경 불가 X.
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

    public Ranking matchWithWinLotto(WinLotto winLotto) {
        Integer matchNumbers = matchWithNumbers(winLotto);
        Integer matchBonus = matchWithBonus(winLotto.bonus);
        return Ranking.compareRanking(matchNumbers, matchBonus);
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

}
