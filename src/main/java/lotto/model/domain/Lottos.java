package lotto.model.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.constant.StateType;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();
    private final HashMap<StateType, Integer> countByState = new HashMap<>();

    public void addLotto(List<Integer> lottoNumbers) {
        lottos.add(new Lotto(lottoNumbers));
    }

    public List<Lotto> getAllLotto() {
        return lottos;
    }

    public void increaseStateCount(StateType stateType) {
        countByState.put(stateType, countByState.getOrDefault(stateType, 0) + 1);
    }

    public HashMap<StateType, Integer> getAllResult() {
        return countByState;
    }
}
