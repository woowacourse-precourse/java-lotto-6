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


    public int match(Lotto a, int matchedNumber) {
        int res = 0;
        for (Lotto lotto : Lottos) {
            if (a.match(lotto) == matchedNumber) {
                res++;
            }
        }
        return res;
    }

    public int match(Lotto a, int matchedNumber, int bonusNumber) {
        int res = 0;
        for (Lotto lotto : Lottos) {
            if (a.match(lotto) == matchedNumber && lotto.contain(bonusNumber)) {
                res++;
            }
        }
        return res;
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
