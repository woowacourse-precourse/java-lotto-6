package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomGenerator;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int amount){
        for (int i = 0; i < amount; i++) {
            List<Integer> LottoNumber = RandomGenerator.generateRandomNums();
            lottos.add(new Lotto(LottoNumber));
        }

    }

}
