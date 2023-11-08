package lotto.domain;

import java.util.List;

public enum Prize {
    FIRST(1, 6, 2000000000),
    SECOND(2, 5, List.of(1), 30000000, ", 보너스 볼 일치"),
    THIRD(3, 5, List.of(0), 1500000, ""),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000);

    private final int grade;
    private final int winningHit;
    private final List<Integer> bonusHit;
    private final int reward;
    private final String message;


    Prize(int grade,
          int winningHit,
          List<Integer> bonusHit,
          int reward,
          String message) {
        this.grade = grade;
        this.winningHit = winningHit;
        this.bonusHit = bonusHit;
        this.reward = reward;
        this.message = message;
    }

    Prize(int grade, int winningHit, int reward) {
        this(grade, winningHit, List.of(0, 1), reward, "");
    }

    public int getGrade() {
        return grade;
    }

    public int getWinningHit() {
        return winningHit;
    }

    public List<Integer> getBonusHit() {
        return bonusHit;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }
}
