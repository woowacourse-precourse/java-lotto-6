package lotto.fixture;

import java.util.List;
import lotto.helper.StubNumberGenerator;
import lotto.model.Lottos;
import lotto.util.NumberGenerator;

public class LottosFixture {

    public static Lottos createLottos(final int count, List<Integer> lotto) {
        NumberGenerator numberGenerator = new StubNumberGenerator(lotto);
        return Lottos.of(count, numberGenerator);
    }
}
