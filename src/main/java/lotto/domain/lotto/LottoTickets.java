package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(PurchasePrice price) {
        this.lottoTickets = createLottoTickets(price);
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    private List<Lotto> createLottoTickets(PurchasePrice price) {
        List<Lotto> tickets = new ArrayList<>();
        int numberOfTickets = getNumberOfTickets(price);

        while (numberOfTickets-- > 0) {
            tickets.add(createNewLotto());
        }

        return tickets;
    }

    private int getNumberOfTickets(PurchasePrice price) {
        return price.getPrice() / 1000;
    }

    private Lotto createNewLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
