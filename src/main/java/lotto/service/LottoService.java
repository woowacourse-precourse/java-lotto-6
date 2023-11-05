package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {

    private LottoTicket lottoTicket;

    public void createLottoTicket(String moneyInput) {
        this.lottoTicket = new LottoTicket(moneyInput);
    }

    public int getTicketCount() {
        return this.lottoTicket.getTicketCount();
    }

    public List<Lotto> purchaseLottoTickets() {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = getTicketCount(); // 티켓의 수량 가져오기
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    public List<List<Integer>> getAllLottoNumbers() {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();
        for (Lotto lotto : purchaseLottoTickets()) {
            allLottoNumbers.add(lotto.getNumbers());
        }
        return allLottoNumbers;
    }

    private static List<Integer> generateLottoNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < 6) {
            int number = Randoms.pickNumberInRange(1, 45);
            uniqueNumbers.add(number);
        }
        List<Integer> lottoNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}