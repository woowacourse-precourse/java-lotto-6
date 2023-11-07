package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Store {
    private final LottoTickets lottoTickets;
    private final int lottoCount;

    public Store(Money money) {
        lottoCount = countLotto(money);
        lottoTickets = makeLottoTickets();
    }

    public int countLotto(Money money) {
        int realMoney = Integer.parseInt(money.getMoney());
        return realMoney / 1000;
    }

    public List<Integer> makeLotto() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private LottoTickets makeLottoTickets() {
        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(makeLotto()))
                .collect(Collectors.toList());

        return new LottoTickets(lottos);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
