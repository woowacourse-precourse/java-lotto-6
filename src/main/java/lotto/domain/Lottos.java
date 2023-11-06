package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Dto.MyLottosDto;

public class Lottos {
    private final List<Lotto> Lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        Lottos.add(lotto);
    }

    public int size() {
        return Lottos.size();
    }

    public MyLottosDto toDto() {
        List<List<Integer>> result = new ArrayList<>();
        for (Lotto lotto : Lottos) {
            List<Integer> tmp = new ArrayList<>();
            lotto.stamp(tmp);
            result.add(tmp);
        }
        return new MyLottosDto(result);
    }
}
