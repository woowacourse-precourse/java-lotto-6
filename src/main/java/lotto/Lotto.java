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
        return rank;
    }

    public void setRank(LottoRank rank) {
        this.rank = rank;
    }

    public enum LottoRank {
        FIRST("2000000000"),
        SECOND("30000000"),
        THIRD("1500000"),
        FOURTH("50000"),
        FIFTH("5000"),
        NO_WIN("0");

        private final String prize;

        LottoRank(String prize) {
            this.prize = prize;
        }

        public String getPrize() {
            return prize;
        }
    }
}
