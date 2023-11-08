package lotto.model;

import lotto.utils.GetRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(createLotto());
        }

        this.lottos = lottos;
    }

    private Lotto createLotto() {
        try {
            return new Lotto(GetRandomNumber.getRandomNumber());
        } catch (IllegalArgumentException e) {
            return createLotto();
        }
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }
}
