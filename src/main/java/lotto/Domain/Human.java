package lotto.Domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.Enum.WinningType;

public class Human {


    private List<Lotto> lottos = new ArrayList<>();
    private Map<WinningType, Integer> winningResult = new EnumMap<>(WinningType.class);
    private Long budget;

    public Human(Long budget) {
        this.budget = budget;
    }

    public boolean buyLotto() {
        if (budget >= 1000) {
            budget -= 1000;
            return true;
        }
        return false;
    }

    public void addLotto(List<Integer> lottoNumber) {
        lottos.add(new Lotto(lottoNumber));
    }

    public int getLottosLength() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
