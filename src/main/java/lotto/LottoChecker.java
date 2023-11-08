package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoChecker {

    private final Lotto winner;
    private final Integer winnerBonus;

    public LottoChecker(Lotto winner, Integer winnerBonus) {
        if (winnerBonus < LottoEnum.NUMBER_MIN.getValue() || LottoEnum.NUMBER_MAX.getValue() < winnerBonus) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 "
                    + LottoEnum.NUMBER_MIN.getValue()
                    + "부터 "
                    + LottoEnum.NUMBER_MAX.getValue()
                    + " 사이의 숫자여야 합니다.");
        }
        if (winner.getNumbers().contains(winnerBonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
        }
        this.winner = winner;
        this.winnerBonus = winnerBonus;
    }

    private Integer getSingleScore(Lotto target) {
        int score = 0;
        if (target.getNumbers().contains(this.winnerBonus)) {
            score += LottoEnum.BONUS_BALL_SCORE.getValue();
        }
        for (Integer guessNumber : this.winner.getNumbers()) {
            if (target.getNumbers().contains(guessNumber)) {
                score += LottoEnum.NORMAL_BALL_SCORE.getValue();
            }
        }
        return score;
    }

    public List<Integer> getTotalScores(List<Lotto> targets) {
        List<Integer> scores = new ArrayList<>();
        for (Lotto target : targets) {
            scores.add(getSingleScore(target));
        }
        return scores;
    }

    private Integer getSinglePrize(Integer score) {
        for (int i = 0; i < LottoEnum.prizeScores.size(); ++i) {
            if (Objects.equals(score, LottoEnum.prizeScores.get(i))) {
                return LottoEnum.prize.get(i);
            }
        }
        return LottoEnum.PRIZE_LAST_MONEY.getValue();
    }

    public List<Integer> getTotalPrizes(List<Lotto> targets) {
        List<Integer> prizes = new ArrayList<>();
        List<Integer> scores = getTotalScores(targets);
        for (Integer score : scores) {
            prizes.add(getSinglePrize(score));
        }
        return prizes;
    }
}
