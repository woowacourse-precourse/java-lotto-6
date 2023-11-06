package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottosPurchased {
    private static final int LOTTO_RANGE_BEGIN_NUMBER = 1;
    private static final int LOTTO_RANGE_END_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    public LottosPurchased(int amount) {
        lottos = new ArrayList<>();
        int numberOfLottos = calculateNumberOfLottos(amount);

        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
    }

    public int getNumberOfLottos() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private int calculateNumberOfLottos(final int amount) {
        return amount / LOTTO_PRICE;
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_BEGIN_NUMBER, LOTTO_RANGE_END_NUMBER, LOTTO_SIZE);
    }
}
