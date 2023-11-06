package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.GameNumberConstants;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public static List<Lotto> generateTickets(int payment) {
        int ticketAmount = payment / GameNumberConstants.LOTTO_PRICE.getValue();
        return generateLottoNumberRepeatNTimes(ticketAmount);
    }

    public static List<Lotto> generateLottoNumberRepeatNTimes(int repeatNumber) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < repeatNumber; i++) {
            lottoTickets.add(new Lotto(generateLottoNumber()));
        }

        return lottoTickets;
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers = lottoNumbers.stream().collect(Collectors.toList());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
