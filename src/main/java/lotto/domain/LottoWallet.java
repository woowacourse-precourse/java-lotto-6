package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    private final List<Lotto> myLotto = new ArrayList<Lotto>();

    public LottoWallet() {}

    public void addLotto(List<Integer> lottoNumbers) {
        myLotto.add(new Lotto(lottoNumbers));
    }

    public void clearWallet() {
        myLotto.clear();
    }

    public List<Lotto> getLottos() {
        return myLotto;
    }
}
