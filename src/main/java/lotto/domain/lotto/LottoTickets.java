package lotto.domain.lotto;

import static lotto.utils.LottoConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.utils.LottoConstants;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(PurchasePrice price) {
        this.lottoTickets = createLottoTickets(price);
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
        return price.getPrice() / LOTTO_PRICE.getValue();
    }

    private Lotto createNewLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUM_MIN.getValue(), LOTTO_NUM_MAX.getValue(),
                LOTTO_NUM_SIZE.getValue());
        return new Lotto(numbers);
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
