package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.money.Money;

public class LottoStore {

    private final NumbersGenerator numbersGenerator;

    public LottoStore(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lottos sellLottoTickets(Money currentMoney) {
        Money remainingMoney = currentMoney;
        if (remainingMoney.isNotEnough()) {
            throw new IllegalArgumentException("로또를 더 이상 발행할 수 없습니다.");
        }
        List<Lotto> lottoTickets = drawTicketsWith(remainingMoney);
        return Lottos.from(lottoTickets);
    }

    private List<Lotto> drawTicketsWith(Money remainingMoney) {
        List<Lotto> lottoTickets = new ArrayList<>();
        while (remainingMoney.isEnough()) {
            Lotto lotto = generateLottoTicket();
            lottoTickets.add(lotto);
            remainingMoney = remainingMoney.decremented();
        }
        return lottoTickets;
    }

    private Lotto generateLottoTicket() {
        List<Integer> numbers = numbersGenerator.generate();
        return Lotto.from(numbers);
    }
}
