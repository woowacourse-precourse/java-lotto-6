package lotto.domain;

import static lotto.utils.Constance.*;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public List<Lotto> buyLottoTickets(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto(pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getValue(),
                    LOTTO_MAX_NUMBER.getValue(), LOTTO_MAX_LENGTH.getValue())));
        }
        return lottoList;
    }
}
