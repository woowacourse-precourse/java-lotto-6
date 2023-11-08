package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public enum Rank {
        NONE(0, "등수 없음", 0),
        FIFTH(3, "5등", 5000),
        FOURTH(4, "4등", 50000),
        THIRD(5, "3등", 1500000, true),
        SECOND(5, "2등", 30000000, false),
        FIRST(6, "1등", 2000000000);

        private final int matchCount;
        private final String rankName;
        private final long winningMoney;
        private final boolean isBonusMatched;

        Rank(int matchCount, String rankName, long winningMoney,boolean isBonusMatched) {
            this.matchCount = matchCount;
            this.rankName = rankName;
            this.winningMoney = winningMoney;
            this.isBonusMatched = isBonusMatched;
        }

        Rank(int matchCount, String rankName, long winningMoney) {
            this(matchCount, rankName, winningMoney, false);
        }

        public long getWinningMoney() {
            return winningMoney;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public static Rank check(int matchCount, boolean matchBonus) {
            for (Rank rank : Rank.values()) {
                if(rank.matchCount == matchCount && (!rank.isBonusMatched || matchBonus)) {
                    return rank;
                }
            }
            return NONE;
        }
    }

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateNumberDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 올바른 값을 입력해주세요.");
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers) {
        Set<Integer> duplicatedNumbers = new HashSet<>(numbers);
        if(numbers.size() != duplicatedNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 올바른 값을 입력해주세요.");
        }
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public Rank checkRank(List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean matchBonus = numbers.contains(bonusNumber);
        return Rank.check(matchCount, matchBonus);
    }

}
