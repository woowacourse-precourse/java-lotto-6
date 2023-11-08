package lotto.domain;

import java.util.List;
import lotto.constant.IllegalStateExceptionType;
import lotto.domain.model.Lotto;

public class LottoManualGenerator implements LottoGenerateStrategy {
    private final List<Lotto> lottos;
    private int index = 0;

    public LottoManualGenerator(List<List<Integer>> inputs) {
        lottos = inputs.stream().map(Lotto::new).toList();
    }

    private void increaseIndex() { index++; }

    public boolean noMoreElements() {
        return index >= lottos.size();
    }

    private void validateHasMoreElement() {
        if (noMoreElements()) {
            throw IllegalStateExceptionType.NO_MORE_ELEMENTS.getException();
        }
    }

    @Override
    public Lotto generate() {
        validateHasMoreElement();
        Lotto lotto = lottos.get(index);
        increaseIndex();

        return lotto;
    }
}
