package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {
    List<Lotto> lottos;
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        lottos.stream()
                .map(s -> s.getNumbers() + "\n")
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    public int getSize() {
        return lottos.size();
    }


}
