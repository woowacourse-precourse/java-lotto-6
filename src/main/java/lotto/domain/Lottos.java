package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.exception.LottoExceptionMessage;
import lotto.util.LottoNumbersGenerator;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    private Lottos(int count) {
        for (int i = 0; i < count; i++) {
            addLotto();
        }
    }

    public static Lottos from(int count) {
        try {
            return new Lottos(count);
        } catch (IllegalArgumentException e) {
            System.out.println(LottoExceptionMessage.MUST_BETWEEN_START_AND_END_INCLUSIVE.getMessage());
        }
        return null;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    private void addLotto() {
        lottos.add(new Lotto(LottoNumbersGenerator.generateLottoNumbers()));
    }
}
