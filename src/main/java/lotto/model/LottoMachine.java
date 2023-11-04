package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstants;

public class LottoMachine implements LottoGenerator {
    @Override
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_NUMBER_MIN,
                LottoConstants.LOTTO_NUMBER_MAX,
                LottoConstants.THE_SIZE_OF_ONE_LOTTO);
        return new Lotto(numbers);
    }

    @Override
    public List<Lotto> generateLottoTickets(int quantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(generate());
        }
        return lottoTickets;
    }
}