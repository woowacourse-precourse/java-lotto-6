package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    public LottoTicketGenerator() {
    }

    public List<LottoTicket> generateLottoTicket(int purchaseAmount) { // 로또 생성

        List<LottoTicket> purchasedLottoTickets = new ArrayList<>(); // 구매한 로또들
        List<Integer> lottoNumbers = new ArrayList<>(); // 한 장의 로또에 들어있는 번호들
        int ticketCount = calculateLottoTicketCount(purchaseAmount); // 구매한 로또 개수

        for (int conut = 0; conut < ticketCount; conut++) {
            lottoNumbers = generateLottoNumbers();
            purchasedLottoTickets.add(new LottoTicket(lottoNumbers));
        }
        return purchasedLottoTickets;
    }

    public List<Integer> generateLottoNumbers() { // 로또 번호 생성
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public int calculateLottoTicketCount(int purchaseAmount) { // 생성할 로또 개수 계산

        return purchaseAmount / 1000;
    }

}
