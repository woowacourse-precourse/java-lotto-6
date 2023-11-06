package lotto.Model;

import java.util.List;
import java.util.stream.Stream;

public enum Rank {

    NONE(0, false, 0, "0개 일치 (0원)"),
    FIFTH(3, false, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchingBall;
    private final boolean bonusBall;
    private final int prize;
    private final String message;

    Rank(int matchingBall, boolean bonusBall, int prize, String message) {
        this.matchingBall = matchingBall;
        this.bonusBall = bonusBall;
        this.prize = prize;
        this.message = message;
    }

    public static int getPrize(Rank rank) {
        return rank.prize;
    }

    public static String getMessage(Rank rank) {
        return rank.message;
    }

    public static Rank calculateRank(Lotto lotto, WinningLotto winningLotto, Bonus bonus) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningLottoNumbers = winningLotto.getWinningLotto().getNumbers();

        int winningCount = 0;
        boolean isBonus = false;

        for (int number : lottoNumbers) {
            if (winningLottoNumbers.contains(number)) {
                winningCount++;
            }
        }
        if (winningCount == 5) {
            isBonus = lottoNumbers.contains(bonus.getBonusNumber());
        }
        //System.out.println(winningCount+ "" +isBonus);
        return getRank(winningCount, isBonus);
    }

    private static Rank getRank(int winningCount, boolean isBonus) {
        Rank[] ranks = Rank.values();

        //System.out.println(ranks);
        return Stream.of(ranks)
                .filter(rank -> rank.matchingBall == winningCount)
                .filter(rank -> rank.bonusBall == isBonus)
                .findAny()
                .orElse(NONE);
    }
}
