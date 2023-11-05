package lotto.domain;


import lotto.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int amount) {
        this.lottos = createLottos(amount);
    }

    private List<Lotto> createLottos(int amount){
        List<Lotto> list = new ArrayList<>(amount);
        return list.stream()
                .map(lotto->new Lotto(Generator.generateRandomNumber()))
                .toList();
    }

}
