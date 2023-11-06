package lotto.model;


import java.util.List;

public class Lotto {
    
    private final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(WinningNumber winningNum) {
        return (int) numbers.stream()
                .filter(winningNum::isContainLottoNumber)
                .count();
    }

    public boolean hasBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }

    private void validateLotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
