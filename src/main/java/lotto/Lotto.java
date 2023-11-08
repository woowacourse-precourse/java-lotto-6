package lotto;


import java.util.List;
import lotto.domain.WinningLottoNumbers;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::isContains)
                .count();
    }
    public boolean matchBonus(WinningLottoNumbers winningLottoNumbers) {
        return isBonus(winningLottoNumbers.getBonus());
    }

    public boolean isBonus(int bonus) {
        return numbers.contains(bonus);
    }

    public boolean isContains(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

}
