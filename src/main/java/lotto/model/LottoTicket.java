package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Lotto> tickets;

    public LottoTicket(int numberOfTickets) {
        tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = generateRandomLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            tickets.add(lotto);
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    private List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }
}


