package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPlayer {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private final List<Lotto> lottos = new ArrayList<>();


    public LottoPlayer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void buyLottos() {
        int numberOfLottoTickets = purchaseAmount / LOTTO_PRICE;

        for (int i = 0; i < numberOfLottoTickets; i++) {
            Lotto lotto = new Lotto(makeRandomNumbers());
            lottos.add(lotto);
        }
    }

    public List<Integer> makeRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers.stream()
                .sorted()
                .toList();
    }
}
