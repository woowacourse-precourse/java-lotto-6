package lotto.model;

import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos from(List<Lotto> lottos) {
        Validator.validateNotNull(lottos);
        return new Lottos(lottos);
    }

    public List<Lotto> getLottoTickets() {
        return new ArrayList<>(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
