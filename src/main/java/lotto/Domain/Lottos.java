package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Util.RandomNumber;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int lottoCount) throws IllegalArgumentException{
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = RandomNumber.generateRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
    }

    public int getSize() {
        return lottos.size();
    }
}
