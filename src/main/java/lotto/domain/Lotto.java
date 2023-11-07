package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final Integer NUM_OF_LOTTO = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> intNumbers) {
        validateSize(intNumbers);
        List<LottoNumber> numbers = intNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        this.numbers = numbers;
    }



    private void validateSize(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != NUM_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개로 구성되어야합니다.");
        }
    }
    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public String lottoNumbers() {
        return numbers.stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public Integer numberOfMatches(Lotto winningNumbers) {
        ArrayList<LottoNumber> copyLottoNumbers = new ArrayList<>();
        copyLottoNumbers.addAll(numbers);
        copyLottoNumbers.retainAll(winningNumbers.numbers);
        return copyLottoNumbers.size();
    }

    public boolean contains(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
