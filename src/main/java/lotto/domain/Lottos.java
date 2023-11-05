package lotto.domain;


import lotto.utils.Generator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<String> getLottosNumber(){
        return lottos.stream()
                .map(lotto -> lotto.getSortedNumbers())
                .toList();
    }

    public int getLottosAmount(){
        return lottos.size();
    }

}
