package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int lottoCost = 1000;
    public static final String ERROR_MESSAGE_NOT_FIT_COST = "금액은 " + lottoCost + "단위입니다.";

    public List<Lotto> purchaseLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        if (money % lottoCost != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_FIT_COST);
        }

        int lottoCount = money / lottoCost;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(publishRandomLotto());
        }
        return lottos;
    }

    public Lotto publishRandomLotto() {
        var rule = LottoNumberRule.BASIC;
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                rule.getMinLottoNumber(),
                rule.getMaxLottoNumber(),
                rule.getLottoNumberSize());
        return new Lotto(lottoNumbers);
    }

    public LottoResult drawLotto(Lotto winningNumber, int bonusNumber) {
        return null;
    }
}
