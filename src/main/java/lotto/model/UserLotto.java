package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class UserLotto {
    private List<Lotto> lottos;
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;


    public UserLotto(int money) {
        this.lottos = new ArrayList<>();
        int numberOfLottos = money / LOTTO_PRICE;
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(generateRandomLotto());
        }
    }
    private Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }
    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottos) {
            builder.append(lotto.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }

}
