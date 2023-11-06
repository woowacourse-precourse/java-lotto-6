package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {
    // 구매한 금액 기반 로또 티켓을 생성
    public List<List<Integer>> generateLottoTicket(int purchaseAmount) {
        int totalTicketCount = purchaseAmount / 1000;
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < totalTicketCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottoTickets.add(lottoNumbers);
        }
        return lottoTickets;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < 6) {
            int lottoNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumbers.contains(lottoNumber)) {
                lottoNumbers.add(lottoNumber);
            }
        }
        return lottoNumbers;
    }
}
