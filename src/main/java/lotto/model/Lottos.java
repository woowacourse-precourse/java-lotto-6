package lotto.model;

import lotto.utils.GetRandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(createLotto()));
        }

        this.lottos = lottos;
    }

    private List<Integer> createLotto() {
        List<Integer> lotto = new ArrayList<>();

        while (lotto.size() != 6) {
            int randomNumber = GetRandomNumber.getRandomNumber();

            if (!lotto.contains(randomNumber)) {
                lotto.add(randomNumber);
            }
        }

        return lotto;
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }
}
