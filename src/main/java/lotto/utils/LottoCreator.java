package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class LottoCreator {

    private final List<Lotto> lottos = new ArrayList<>();

    public void createLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers
                    = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randomNumbers));
        }
    }

    public List<List<Integer>> getCreatedLottos() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

}
