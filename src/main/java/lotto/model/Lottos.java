package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.RandomNumber;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static List<Lotto> generator(int count) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> number = RandomNumber.generate();
            Collections.sort(number);

            result.add(new Lotto(number));
        }
        return result;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
