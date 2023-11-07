package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> allLotto = new ArrayList<>();

    public Lottos(Integer count){
        IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .forEach(allLotto::add);
    }
    public Lotto getLotto(Integer index){
        return allLotto.get(index);
    }
}
