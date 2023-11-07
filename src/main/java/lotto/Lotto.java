package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        valideteDuplicatedNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 갯수는 6개여야 합니다.");
        }
    }

    private void valideteDuplicatedNumbers(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoRank match(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean hasBonusNumber = numbers.contains(bonusNumber);

        return LottoRank.getRank(matchCount, hasBonusNumber);
    }
}
