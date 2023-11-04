package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public void lottoMachineService(int lottoTicketCount) {
        List<List<Integer>> totalLottoTickets = new ArrayList<>();
        // 계산된 티켓 수만큼 로또 번호를 생성하여 저장
        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers); // 로또 번호 정렬
            totalLottoTickets.add(numbers);
        }
    }
}
