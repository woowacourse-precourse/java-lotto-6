package lotto.model;

import static lotto.constants.LottoDetails.LOTTO_NUMBER_MAX;
import static lotto.constants.LottoDetails.LOTTO_NUMBER_MIN;
import static lotto.constants.LottoDetails.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static List<Lotto> buyLottoTickets(Money money) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < money.numberOfLottoTickets(); i++) {
            tickets.add(new Lotto(generateLottoNumbers()));
        }
        return tickets;
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
    }
}
