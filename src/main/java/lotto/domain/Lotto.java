package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    private final List<Integer> numbers;

    public enum Prize {
        FIRST(6, 2_000_000_000),
        SECOND(5 + 5, 30_000_000),
        THIRD(5, 1_500_000),
        FOURTH(4, 50_000),
        FIFTH(3, 5_000);

        private final int matchCount;
        private final int prizeMoney;

        Prize(int matchCount, int prizeMoney) {
            this.matchCount = matchCount;
            this.prizeMoney = prizeMoney;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sort(List<Integer> unSortNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>(unSortNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
