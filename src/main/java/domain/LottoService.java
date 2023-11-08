package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    public List<List<Integer>> generateLottoNumbers(int numberOfSheets) {
        List<List<Integer>> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfSheets; i++) {
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(ticket);
            tickets.add(ticket);
        }

        return tickets;
    }
}
