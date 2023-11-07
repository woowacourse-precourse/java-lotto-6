package lotto.domain.answer.number;

import lotto.domain.Lotto;

public class LottoAnswer {
    private final Lotto answer;

    private final Integer bonus;

    public LottoAnswer(Lotto answer, Integer bonus) {
        this.answer = answer;
        this.bonus = bonus;
    }

    public int getAnswerSize() {
        return answer.getSize();
    }
}
