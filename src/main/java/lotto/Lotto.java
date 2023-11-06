package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {

        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (duplicationCheck(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        if (!rangeCheck(numbers)) {
            throw new IllegalArgumentException("각 숫자는 1부터 45 사이여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    private boolean duplicationCheck(List<Integer> numbers) {
        HashSet<Integer> checkNumber = new HashSet<>(numbers);

        return checkNumber.size() != numbers.size();
    }

    private boolean rangeCheck(List<Integer> numbers) {
        for (int rangeNumber : numbers) {

            if (rangeNumber < 1 || rangeNumber > 45) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareNumbers(List<Integer> winNumbers) {
        int matchCount = 0;

        for (int number : numbers) {

            if (winNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean containMatch(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public LottoRank determineRank(Lotto winNumber, int bonusMatch) {
        int matchCount = compareNumbers(winNumber.getNumbers());
        boolean matchbonus = containMatch(bonusMatch);

        return LottoRank.rankCheck(matchCount, matchbonus);
    }

    public enum LottoRank {
        FIRST(6, 2_000_000_000, false),
        SECOND(5, 30_000_000, false),
        THIRD(5, 1_500_000, false),
        FOURTH(4, 50_000, false),
        FIFTH(3, 5_000, false),
        NONE(0, 0, false);

        private final int matchCount;
        private final int prize;
        private final boolean matchBonus;

        LottoRank(int matchCount, int prize, boolean matchBonus) {
            this.matchCount = matchCount;
            this.prize = prize;
            this.matchBonus = matchBonus;
        }

        public static LottoRank rankCheck(int matchCount, boolean matchBonus) {
            for (LottoRank rank : values()) {

                if (rank.matchCount == matchCount && (!rank.matchBonus || matchBonus)) {
                    return rank;
                }
            }
            return NONE;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getPrize() {
            return prize;
        }
    }
}