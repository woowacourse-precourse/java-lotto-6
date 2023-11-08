package lotto.model.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import lotto.constant.StateType;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();
    private final HashMap<StateType, Integer> countByState = new HashMap<>();

    public void addLotto(List<Integer> lottoNumbers) {
        if(!isSortedList(lottoNumbers)){
            lottoNumbers.sort(Comparator.naturalOrder());
        }
        lottos.add(new Lotto(lottoNumbers));
    }

    private boolean isSortedList(List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            if (lottoNumbers.get(i) > lottoNumbers.get(i + 1)) {
                return false;
            }
        }
        return true;
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
