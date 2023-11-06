package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {
    public List<Lotto> purchaseLottoTickets(int money) {
        validateMoney(money);
        int numberOfLottoTickets = money / 1000;
        List<Lotto> lottoTickets = new ArrayList<>();
        for(int i = 0; i < numberOfLottoTickets; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lottoTicket = new Lotto(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private void validateMoney(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다.");
        }
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }
}