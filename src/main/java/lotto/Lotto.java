package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private LottoRank rank;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.rank = LottoRank.NO_WIN;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoRank getRank() {
        return this.rank;
    }

    public void setRank(LottoRank rank) {
        this.rank = rank;
    }
}
