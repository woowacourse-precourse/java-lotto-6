package lotto.domain;

import static lotto.global.constants.NumberType.LOTTO_SIZE;
import static lotto.global.constants.NumberType.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(int count) {
        lottos = new ArrayList<>();
        generateRandomNumber(count);
    }

    private void generateRandomNumber(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    MIN_LOTTO_NUMBER.getValue(),
                    MIN_LOTTO_NUMBER.getValue(),
                    LOTTO_SIZE.getValue());
            lottos.add(Lotto.from(numbers));
        }
    }

    public static Lottos from(int count) {
        return new Lottos(count);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getSize() {
        return lottos.size();
    }
}
