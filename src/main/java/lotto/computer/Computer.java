package lotto.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.lotto.Lotto;
import lotto.lotto.Lottos;

public class Computer {

    public Lottos createUserLottos(int money) {
        List<Lotto> lottos = createLottoList(money);

        return new Lottos(lottos);
    }

    private List<Lotto> createLottoList(int money) {
        return IntStream.rangeClosed(1, money / 1000)
                .mapToObj(num -> {
                            List<Integer> randomNumbers =
                                    Randoms.pickUniqueNumbersInRange(1, 45, 6);
                            randomNumbers.sort(Integer::compareTo);
                            return new Lotto(randomNumbers);
                        }
                )
                .toList();
    }
}
