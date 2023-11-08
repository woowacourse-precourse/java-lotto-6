package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private List<Lotto> lottos;

    public LottoShop(int lottoAmonut) {
        lottos = new ArrayList<>();
        makeLottos(lottoAmonut);
    }

    public void makeLottos(int lottoAmount) {
        for (int count = 1; count <= lottoAmount; count++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
