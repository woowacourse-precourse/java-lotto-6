package lotto.model;

import lotto.util.Validator;

import java.util.ArrayList;
import java.util.List;

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
}
