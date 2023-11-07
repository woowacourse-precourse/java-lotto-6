package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.util.Generator;

public class LottoMachine {

    public final Lotto issueLotto(final Generator generator) {
        List<Integer> issuedLotto = generator.generate();
        Collections.sort(issuedLotto);
        return new Lotto(Collections.unmodifiableList(issuedLotto));
    }
}
