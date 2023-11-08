package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private int lottoTicketCount;
    private int purchaseAmount;
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTicket(int lottoTicketCount, int purchaseAmount) {
        this.lottoTicketCount = lottoTicketCount;
        this.purchaseAmount = purchaseAmount;
        generateLottoNumbers();
    }

    public void generateLottoNumbers() {
        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoTickets.add(lotto);
        }
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
