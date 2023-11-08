package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lottery {
    private final List<Integer> winningNumbers;
    private final Rank rank;




    Lottery(List<Integer> lottoNumbers, int bonusNumber) {
        List<Integer> winningNumbers = makeWinningNumbers();
        this.winningNumbers = winningNumbers;
        Rank rank = whatIsRank(lottoNumbers, bonusNumber);
        this.rank = rank;
    }

    // 로또 당첨 번호 생성
    private static List<Integer> makeWinningNumbers() {
        List<Integer> winningNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return winningNumbers;
    }

    // 로또 당첨 번호와 입력한 당첨 번호가 몇 개나 일치하는지 확인하고 일치하는 번호 개수 반환
    public int matchingNumbers(List<Integer> lottoNumbers) {
        List<Integer> winningNumbers = this.winningNumbers;
        int numberOfMatches = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                numberOfMatches++;
            }
        }
        return numberOfMatches;
    }

    // 순위 정하기
    public Rank whatIsRank(List<Integer> lottoNumbers, int bonusNumber) {
        int numberOfMatches = this.matchingNumbers(lottoNumbers);
        if (numberOfMatches == 6) {
            return Rank.FIRST;
        }
        if (numberOfMatches == 5 && this.winningNumbers.contains(bonusNumber)) {
            return Rank.SECOND;
        }
        if (numberOfMatches == 5) {
            return Rank.THIRD;
        }
        if (numberOfMatches == 4) {
            return Rank.FORTH;
        }
        if (numberOfMatches == 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Rank getRank() {
        return rank;
    }
}

enum Rank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000),
    NONE(0);

    private final int winnings;

    Rank(int winnings) {
        this.winnings = winnings;
    }

    public int getWinnings() {
        return winnings;
    }

}
