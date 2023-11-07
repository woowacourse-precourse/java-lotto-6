package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int count) {
        getLottos(count);
    }

    private void getLottos(int count) {
        while (lottos.size() < count) {
            try {
                GenerateNumbers numbers = new GenerateNumbers();
                Lotto lotto = new Lotto(numbers.getNumbers());
                lottos.add(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
