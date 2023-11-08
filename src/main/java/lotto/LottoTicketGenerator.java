package lotto;

import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicketGenerator {

    public static Lotto generateLottoTicket() {
        List<Integer> numbers = getRandomNumber();
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private static List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
