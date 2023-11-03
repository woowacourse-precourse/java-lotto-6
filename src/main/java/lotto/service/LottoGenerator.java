package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoGenerator {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Lotto> generateLottoTickets(int lottoTicketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            Lotto lotto = new Lotto(generateLottoNumbers());
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }

}
