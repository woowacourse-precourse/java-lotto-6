package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lottos {
    List<Lotto> bundleLotto;
    public Lottos(List<Lotto> bundleLotto) {
        this.bundleLotto = bundleLotto;
    }

    public List<Lotto> getBundleLotto() {
        return Collections.unmodifiableList(bundleLotto);
    }

    public String toString() {
        List<Integer> orderedLotto;
        StringBuilder lottoNumbers = new StringBuilder();

        for (Lotto lotto : bundleLotto) {
            orderedLotto = new ArrayList<>(lotto.getNumbers());
            orderedLotto.sort(Comparator.naturalOrder());
            lottoNumbers.append(orderedLotto + "\n");
        }

        return lottoNumbers.toString();
    }

    public int getSize() {
        return bundleLotto.size();
    }


}
