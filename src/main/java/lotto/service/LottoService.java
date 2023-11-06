package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {
    public List<Lotto> purchaseLottoTickets(int money) {
        int numberOfLottoTickets = money / 1000;
        List<Lotto> lottoTickets = new ArrayList<>();
        for(int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lottoTicket = new Lotto(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }
}