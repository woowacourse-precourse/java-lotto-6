package lotto.model;

import java.util.List;

public class AnswerLotto extends Lotto {
    private final LottoNo bonusNo;

    public AnswerLotto(List<Integer> numbers, int bonusNo) {
        super(numbers);
        this.bonusNo = new LottoNo(bonusNo);
    }

    @Override
    public boolean isAnswerLotto() {
        return true;
    }
}
