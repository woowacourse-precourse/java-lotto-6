package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoBuying {
    public static List<Lotto> buyLotto(int amount) {
        int numOfLottos = amount / 1000;
        List<Lotto> purchasedLottos = new ArrayList<>();

        for (int i = 0; i < numOfLottos; i++) {
            List<Integer> lottoNumbers = LottoGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            purchasedLottos.add(lotto);
        }

        return purchasedLottos;
    }
}
