package lotto.domain.machine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DrawTicketNumber {
    public static List<Integer> drawLottoTicket() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Set<Integer> duplicate = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != duplicate.size()) {
            return drawLottoTicket();
        }
        return lottoNumbers;
    }
}
