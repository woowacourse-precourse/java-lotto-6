package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottosPurchased {
    private final List<Lotto> lottos;

    public LottosPurchased(int amount) {
        lottos = new ArrayList<>();
        int numberOfLottos = calculateNumberOfLottos(amount);

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getNumberOfLottos() {
        return lottos.size();
    }

    private int calculateNumberOfLottos(final int amount) {
        return amount / LottoInfo.PRICE.getNumber();
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoInfo.RANGE_BEGIN.getNumber(), LottoInfo.RANGE_END.getNumber(), LottoInfo.SIZE.getNumber());
    }
}
