package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import static lotto.common.ContstantValue.*;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private int purchaseAmount = 0;

    public List<Lotto> buyLotto(int price) {
        purchaseAmount += price;
        int lottoCount = price / LOTTO_UNIT_PRICE.getValue();

        List<Lotto> lotteryTickets = generateLottoNums(lottoCount);
        return lotteryTickets;
    }

    private List<Lotto> generateLottoNums(int lottoCount) {
        List<Lotto> lotteryTickets = new ArrayList<>();

        for(int i=0; i<lottoCount; i++) {
            List<Integer> lotteryTicket = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM.getValue(), LOTTO_MAX_NUM.getValue(), LOTTO_UNIT_SIZE.getValue());
            List<Integer> sortedTicket = lotteryTicket.stream().sorted().toList();
            lotteryTickets.add(new Lotto(sortedTicket));
        }
        return lotteryTickets;
    }
}
