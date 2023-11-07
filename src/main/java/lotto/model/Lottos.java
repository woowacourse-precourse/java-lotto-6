package lotto.model;

import java.util.Collections;
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
        StringBuilder stringBuilder = new StringBuilder();

        bundleLotto.stream()
                .map(s -> s.getNumbers().toString() + "\n")
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    public int getSize() {
        return bundleLotto.size();
    }


}
