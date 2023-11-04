package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private List<Integer> generateLottoNumbers() {
        List<Integer> randomNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNum);
        return randomNum;
    }
}
