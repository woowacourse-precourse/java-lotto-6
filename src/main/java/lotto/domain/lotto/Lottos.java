package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int ticketCount) {
        lottos = makeLottos(ticketCount);
    }

    private List<Lotto> makeLottos(int ticketCount) {
        return IntStream.range(0, ticketCount)
                .mapToObj(i -> {
                    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUM, Lotto.MAX_NUM, Lotto.SIZE);
                    return new Lotto(numbers);
                })
                .toList();
    }

    public String printLottos() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> {
            sb.append(lotto.print());
            sb.append("\n");
        });
        return sb.toString();
    }
}
