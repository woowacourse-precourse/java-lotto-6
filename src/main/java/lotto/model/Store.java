package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Store {
    private final LottoTickets lottoTickets;
    private final int lottoCount;

    public Store(Money money) {
        lottoTickets = makeLottoTickets();
        lottoCount = countLotto(money);
    }

    public static int countLotto(Money money) {
        int realMoney = Integer.parseInt(money.getMoney());
        return realMoney / 1000;
    }

    public static List<Integer> makeLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private LottoTickets makeLottoTickets() {
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(makeLotto()))
                .collect(Collectors.toList());

        return new LottoTickets(lottos);
    }
}
