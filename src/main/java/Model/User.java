package Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class User {
    static final int SMALLEST_LOTTO_NUMBER = 1;
    static final int BIGGEST_LOTTO_NUMBER = 45;
    static final int LOTTO_NUMBER_COUNT = 6;

    private List<Lotto> lottos;

    public User() {
        lottos = new ArrayList<>();
    }

    public void generateLottos(int amount) {
        for (int i = 0; i < amount; i++) {
            generateSingleLotto();
        }
    }

    private void generateSingleLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(SMALLEST_LOTTO_NUMBER, BIGGEST_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        lottos.add(new Lotto(lottoNumbers));
    }


}
