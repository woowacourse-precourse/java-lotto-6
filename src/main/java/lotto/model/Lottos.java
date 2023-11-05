package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.GameConfig;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(PurchaseAmount purchaseAmount) {
    }

    private void generateLottos(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculateLottoCount();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                GameConfig.MIN_LOTTO_NUMBER.getValue(),
                GameConfig.MAX_LOTTO_NUMBER.getValue(),
                GameConfig.WINNING_NUMBERS_COUNT.getValue());
    }
}
