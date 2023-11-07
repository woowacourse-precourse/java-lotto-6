package lotto.Domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Human {


    private List<Lotto> lottos = new ArrayList<>();
    private Map<WinningType, Integer> winningResult = new EnumMap<>(WinningType.class);
    private Long budget;

    public Human(Long budget) {
        this.budget = budget;
    }

    public boolean buyLotto() {
        if (budget > 1000) {
            budget -= 1000;
            return true;
        }
        return false;
    }

    public void addLotto(List<Integer> lottoNumber) {
        Lotto lotto = new Lotto(lottoNumber);
        lottos.add(lotto);
    }

    public int getLottosLength() {
        return Array.getLength(lottos);
    }

    @Override
    public String toString() {
        return "개를 구매했습니다.";
    }
}
