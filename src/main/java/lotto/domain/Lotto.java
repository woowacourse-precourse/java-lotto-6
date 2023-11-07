package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto generateRandomLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .stream()
            .sorted()
            .toList();
        return Lotto.of(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR]로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR]로또 번호는 1~45 사이여야 합니다.");
        }
    }

    public String toString() {
        return numbers.toString();
    }

    public int getMatchCount(Lotto userLottoNumbers) {
        return (int) numbers.stream()
            .filter(userLottoNumbers.numbers::contains)
            .count();
    }

    public boolean checkDuplicate(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
