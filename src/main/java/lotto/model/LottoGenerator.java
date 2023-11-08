package lotto.model;

import static lotto.configuration.LottoConfiguration.LOTTO_BOUNDARY_END_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_BOUNDARY_START_NUMBER;
import static lotto.configuration.LottoConfiguration.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> issueLottoTickets(Money money) {
        List<Lotto> lottoTickets = new ArrayList<Lotto>();
        for (int count = 0; count < money.moneyToLottoCount(); count++) {
            lottoTickets.add(createLotto());
        }
        return lottoTickets;
    }

    public static Lotto createLotto() {
        return new Lotto(generateRandomLottoNumber());
    }

    private static List<Integer> generateRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_BOUNDARY_START_NUMBER.get(), LOTTO_BOUNDARY_END_NUMBER.get(),
                LOTTO_SIZE.get());
    }
}
