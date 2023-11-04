package lotto.lottocompany;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoCompany {

    private final LottoBundle lottoBundle;

    public LottoCompany() {
        this.lottoBundle = LottoBundle.create(new ArrayList<>());
    }

    public LottoBundle getLottoBundle() {
        return lottoBundle;
    }

    public void publishNLotto(int publishCount) {
        List<Lotto> bundle = new ArrayList<>(publishCount);
        for (int count = 0; count < publishCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            bundle.add(new Lotto(numbers));
        }
        this.lottoBundle.addLotto(bundle);
    }
}
