package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {

    private List<List<Integer>> lottos = new ArrayList<>();

    public LottoPublisher(int issueAbleCount) {
        generateLottos(issueAbleCount);
    }

    private void generateLottos(int issueAbleCount) {
        while (lottos.size() < issueAbleCount) {
            Lotto lotto = new Lotto(RandomNumber.generateLottoNumbers());
            lottos.add(lotto.getLottoNumbers());
        }
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
