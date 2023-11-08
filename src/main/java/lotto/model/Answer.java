package lotto.model;

import java.util.List;

public class Answer {
    private final List<Integer> answerNumber;
    private final int bonusNumber;

    public Answer(List<Integer> answer, int bonus) {
        this.answerNumber = answer;
        this.bonusNumber = bonus;
    }

    public List<Integer> getAnswerNumber() {
        return this.answerNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

}
