package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private final List<Integer> answerNumber;
    private final int bonuseNumber;

    public Answer(List<Integer> answer, int bonus) {
        this.answerNumber = answer;
        this.bonuseNumber = bonus;
    }

    public List<Integer> getAnswerNumber() {
        return this.answerNumber;
    }

    public int getBonusNumber() {
        return this.bonuseNumber;
    }

}
