package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(int lottoMoney) {
        buildLottos(lottoMoney);
    }

    private void buildLottos(int lottoMoney) {
        int lottoCount = lottoMoney / 1000;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedLottoNums = lottoNums.stream().sorted().toList();
            lottos.add(new Lotto(sortedLottoNums));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
