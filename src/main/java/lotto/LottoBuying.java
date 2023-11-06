package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;

public class LottoBuying {
    public List<Lotto> buyLottos(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }

        List<Lotto> lottos = new ArrayList<>();
        int numberOfLottos = purchaseAmount / 1000;
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> randomNumbers = LottoGenerator.generateRandomNumbers();
            Collections.sort(randomNumbers);
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}