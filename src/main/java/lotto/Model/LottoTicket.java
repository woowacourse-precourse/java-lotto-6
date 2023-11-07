package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    public static List<Lotto> generateLottoTickets(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / 1000;
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            Lotto lottoTicket = generateSingleLottoTicket();
            lottoTickets.add(lottoTicket);
        }

        return lottoTickets;
    }

    public static Lotto generateSingleLottoTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lottoTicket = new Lotto(numbers);
        return lottoTicket;
    }

}
