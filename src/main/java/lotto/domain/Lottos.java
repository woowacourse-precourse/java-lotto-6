package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public record Lottos(List<Lotto> lottos) {
    private static final int ZERO = 0;

    public static Lottos from(final int quantity) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = ZERO; i < quantity; i++) {
            Lotto createLotto = Lotto.createRandomLotto();
            generatedLottos.add(createLotto);
        }
        return new Lottos(generatedLottos);
    }
}
