package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.wrapper.Lotto;
import lotto.domain.wrapper.Money;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.handler.ConstantsHandler.*;

public class GenerateLotto {

    private final List<Lotto> buyLottos;

    private GenerateLotto(Money money) {
        this.buyLottos = generateBuyLottos(money);
    }

    public static GenerateLotto create(Money money) {
        return new GenerateLotto(money);
    }

    private List<Lotto> generateBuyLottos(Money money) {
        int ticket = money.getTicket();

        List<Lotto> buyLottos = IntStream.range(0, ticket)
                .mapToObj(ticketCount -> Lotto.create(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE)))
                .collect(Collectors.toList());

        return buyLottos;
    }

    public List<Lotto> getBuyLottos() {
        return List.copyOf(buyLottos);
    }
}
