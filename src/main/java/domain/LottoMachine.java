package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {

    public List<List<Integer>> lottoMachineService(int lottoTicketCount) {
        List<List<Integer>> totalLottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            totalLottoTickets.add(numbers);
        }
        return totalLottoTickets;
    }
}
