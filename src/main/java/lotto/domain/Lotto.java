package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Lotto {

    public static final int VALID_MIN_NUMBER = 1;
    public static final int VALID_MAX_NUMBER = 45;
    public static final int VALID_NUMBER_SIZE = 6;
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);

        this.numbers = List.copyOf(getLottoNumbersFrom(numbers));
    }

    public static Lotto of(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);

        return new Lotto(numbers);
    }

    public void acceptLottoNumbers(Consumer<List<Integer>> consumer) {
        consumer.accept(numbers);
    }

    public void contain(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스번호와 당첨번호는 같을 수 없습니다.");
        }
    }

    public int getMatchedCountCompareTo(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(Integer lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public boolean contains(BonusBall bonusBall) {
        return bonusBall.contains(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 유효한 갯수의 로또 번호가 필요합니다.");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(e -> e < VALID_MIN_NUMBER || e > VALID_MAX_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 유효범위를 벗어났습니다. 유효범위 : 1 ~ 45");
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 6개의 숫자를 입력해주세요.");
        }
    }

    private List<Integer> getLottoNumbersFrom(Collection<Integer> numbers) {
        TreeSet<Integer> sorted = new TreeSet<>(numbers);
        return new ArrayList<>(sorted);
    }

}
