package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Constants;
import lotto.model.Lotto;

public class LottoGenerator {

    public static List<Lotto> generateLottoTickets(int lottoTicketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            Lotto lotto = new Lotto(generateLottoNumbers());
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER,
            Constants.LOTTO_NUMBER_COUNT);
    }

}
