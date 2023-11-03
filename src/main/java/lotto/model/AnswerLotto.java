package lotto.model;

import java.util.List;

public class AnswerLotto extends Lotto {
    public AnswerLotto(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public boolean isAnswerLotto() {
        return true;
    }
}
