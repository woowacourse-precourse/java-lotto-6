package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.util.Generator;

public class LottoMachine {

    public Lotto issueLotto(Generator generator) {
        List<Integer> issuedLotto = generator.generate();
        Collections.sort(issuedLotto);
        return new Lotto(issuedLotto);
    }
}
