package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoQuantity {

    private final List<Lotto> lottos;

    public LottoQuantity(int tickets) {
        this.lottos = createLottos(tickets);
    }

    private List<Lotto> createLottos(int tickets) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < tickets) {
            putLotto(lottos);
        }
        return lottos;
    }

    private void putLotto(List<Lotto> lottos) {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        lottos.add(new Lotto(numbers));
    }


    public List<Lotto> getLottos() {

        return Collections.unmodifiableList(lottos);
    }
}
