package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static lotto.domain.constants.LottoConfig.LOTTO_COUNT;
import static lotto.domain.constants.LottoConfig.LOTTO_NUMBER_MAX;
import static lotto.domain.constants.LottoConfig.LOTTO_NUMBER_MIN;
import static lotto.domain.constants.LottoConfig.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoService {
    public Lottos generateLottoTicket() {
        List<Lotto> lottoTicket = new ArrayList<>();
        while (lottoTicket.size() < LOTTO_COUNT.getValue()) {
            lottoTicket.add(generateLotto());
        }
        return Lottos.of(lottoTicket);
    }

    private Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < LOTTO_SIZE.getValue()) {
            numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN.getValue(), LOTTO_NUMBER_MAX.getValue(),
                    LOTTO_SIZE.getValue());
        }
        return new Lotto(numbers);
    }
}
