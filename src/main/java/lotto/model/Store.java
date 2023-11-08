package lotto.model;

import static lotto.utils.Constants.END_LOTTO_NUMBER;
import static lotto.utils.Constants.LOTTO_SIZE;
import static lotto.utils.Constants.ONE_LOTTO_PRICE;
import static lotto.utils.Constants.START_LOTTO_NUMBER;

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

        return realMoney / ONE_LOTTO_PRICE;
    }

    private List<Integer> makeLotto() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_SIZE));
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
