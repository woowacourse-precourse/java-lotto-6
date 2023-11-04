package lotto.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.lotto.Lotto;
import lotto.lotto.Lottos;

public class Computer {

    public Lottos createUserLottos(int money) {
        List<Lotto> lottos = IntStream.rangeClosed(1, money / 1000)
                .mapToObj(num -> new Lotto(
                        Randoms.pickUniqueNumbersInRange(1, 45, 6))
                )
                .toList();

        return new Lottos(lottos);
    }
}
