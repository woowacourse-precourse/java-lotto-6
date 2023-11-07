package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;
    private final BuyingLotto buyingLotto;
    private final int purchaseAmount;

    public LottoGame(int purchaseAmount, BuyingLotto buyingLotto) {
        this.purchaseAmount = purchaseAmount;
        this.buyingLotto = buyingLotto;
        this.lottos = generateLottos();
    }

    private List<Lotto> generateLottos() {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            generatedLottos.add(new Lotto(numbers));
        }
        return generatedLottos;
    }
}
