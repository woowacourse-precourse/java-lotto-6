package lotto.v3.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.v3.util.LottoConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public Lotto generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_NUMBER_MIN.getValue(),
                LottoConstants.LOTTO_NUMBER_MAX.getValue(),
                LottoConstants.LOTTO_NUMBERS_SIZE.getValue()
        ).stream().sorted().toList();
        return new Lotto(numbers);
    }

    public List<Lotto> generateTickets(int count) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(generateLottoNumbers());
        }
        return tickets;
    }

}