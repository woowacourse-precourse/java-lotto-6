package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private LottoRank rank;

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

    public LottoRank getRank() {
        return rank;
    }

    public void setRank(LottoRank rank) {
        this.rank = rank;
    }

    // TODO: 추가 기능 구현

    public enum LottoRank {

        FIRST, SECOND, THIRD, FOURTH, FIFTH, LOOSE


//        FIRST("6개 일치 (2,000,000,000원) - "),
//        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
//        THIRD("5개 일치 (1,500,000원) - "),
//        FOURTH("4개 일치 (50,000원) - "),
//        FIFTH("3개 일치 (5,000원) - "),
//        LOOSE("");
//        final private String rank;
//
//        LottoRank(String rank) {
//            this.rank = rank;
//        }
    }
}
