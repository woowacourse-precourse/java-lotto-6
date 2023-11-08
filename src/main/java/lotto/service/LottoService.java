package lotto.service;

import lotto.validator.Lotto;
import lotto.validator.LottoTicketCount;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
    private LottoTicketCount lottoTicket;

    public void createLottoTicket(String moneyInput) {
        this.lottoTicket = new LottoTicketCount(moneyInput);
    }

    public int getTicketCount() {
        return this.lottoTicket.getTicketCount();
    }

    public List<Lotto> generateLottoNumbers() {
        List<Lotto> lottoNumbers = new ArrayList<>();
        int lottoCount = getTicketCount();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(createSingleGameLottoNumbers());
        }
        return lottoNumbers;
    }

    private Lotto createSingleGameLottoNumbers() {
        List<Integer> singleGameLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(singleGameLottoNumbers);
    }
}