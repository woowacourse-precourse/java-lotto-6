package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.NumberGenerator;
import lotto.domain.lotto.RandomNumberGenerator;

public class LottoStore {

    private final List<Lotto> issuedLotto;

    public LottoStore() {
        this.issuedLotto = new ArrayList<>();
    }

    public void issueLotto() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        issuedLotto.add(new Lotto(randomNumberGenerator.generateNumbers()));
    }

    public List<Lotto> getIssuedLotto() {
        return Collections.unmodifiableList(issuedLotto);
    }

}
