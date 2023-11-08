package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AllLotto {
    private final List<Lotto> allLotto = new ArrayList<>();

    public AllLotto(Integer count) {
        try {
            IntStream.range(0, count)
                    .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                    .forEach(allLotto::add);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public List<Integer> getLotto(Integer index) {
        return allLotto.get(index).getNumbers();
    }

    public Integer size() {
        return allLotto.size();
    }
}
