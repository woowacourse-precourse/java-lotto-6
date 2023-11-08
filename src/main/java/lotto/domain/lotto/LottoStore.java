package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.money.Money;

public class LottoStore {
    private final NumbersGenerator numbersGenerator;

    public LottoStore(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos sellLottoTickets(Money money) {
        money.checkForLottoPurchase();
        List<Lotto> lottoTickets = drawTicketsWith(money);
        return Lottos.from(lottoTickets);
    }

    private List<Lotto> drawTicketsWith(Money money) {
        List<Lotto> lottoTickets = new ArrayList<>();
        while (money.isEnough()) {
            Lotto lotto = generateLottoTicket();
            lottoTickets.add(lotto);
            money = money.decremented();
        }
        return lottoTickets;
    }

    private Lotto generateLottoTicket() {
        List<Integer> numbers = numbersGenerator.generate();
        return Lotto.from(numbers);
    }
}
