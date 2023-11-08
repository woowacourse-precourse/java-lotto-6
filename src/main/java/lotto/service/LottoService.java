package lotto.service;

import static lotto.global.constant.LottoNumber.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTickets;

public class LottoService {

    public LottoTickets createLottoTickets(int purchaseAmount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for(int i=0;i<purchaseAmount;i++){
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                    LOTTO_NUMBER_COUNT);
            lottoTickets.add(new Lotto(randomNumbers));
        }
        return new LottoTickets(lottoTickets);
    }
    

}
