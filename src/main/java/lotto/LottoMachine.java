package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
    
    public LottoResult checkResults(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        return new LottoResult(lottos, winningLotto, bonusNumber);
    }
}