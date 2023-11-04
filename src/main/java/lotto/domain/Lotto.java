package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final Integer LOTTO_LENGTH = 6;
    private static final Integer RANGE_START_NUMBER = 1;
    private static final Integer RANGE_END_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자로 구성되야합니다");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                   .collect(
                        Collectors.toSet()
                    )
                   .size()
                != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자로 이루어진 로또를 생성할 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch( number -> !(RANGE_START_NUMBER <= number && number <= RANGE_END_NUMBER))) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 허용 범위는 1~45까지입니다.");
        }
    }

    public LottoResult compareWithWinnerLotto(List<Integer> winnerNumbers, Integer bonusNumber) {
        Integer countOfSameNumbers = compareWithWinnerNumbers(winnerNumbers);
        Boolean checkBonus = compareWithBonusNumber(bonusNumber);
        return new LottoResult(countOfSameNumbers, checkBonus);
    }


    private Integer compareWithWinnerNumbers(List<Integer> winnerNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(number -> winnerNumbers.contains(number))
                .count());
    }

    private Boolean compareWithBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Lotto lotto = (Lotto) that;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
