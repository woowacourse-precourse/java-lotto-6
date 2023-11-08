package lotto.domain;

import lotto.constants.LottoEnum;
import lotto.utils.CommonHelper;

import java.util.*;

public class LottoManager {
    int numberOfTickets;

    public LottoManager(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public List<Lotto> createLotto(int ticketCnt) {
        List<Lotto> lottos = new LinkedList<>();
        for (int i = 0; i < ticketCnt; i++) {
            lottos.add(new Lotto(CommonHelper.numGenerator()));
        }
        return lottos;
    }

    public List<Integer> sameNumberForWin(List<Integer> userLottoNumbers, List<Lotto> lottos, int bonusNumber) {
        List<Integer> sameNumbers = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0));
        int index = 0;
        int addCnt = 0;
        for (Lotto lotto : lottos) {
            index = CommonHelper.countSameNumber(userLottoNumbers, lotto.getNumbers());
            addCnt = sameNumbers.get(index) + 1;
            sameNumbers.set(index, addCnt);
            if (index == 5 && lotto.getNumbers().contains(bonusNumber)) {
                addCnt = sameNumbers.get(5) - 1;
                sameNumbers.set(5, addCnt);
                addCnt = sameNumbers.get(7) + 1;
                sameNumbers.set(7, addCnt);
            }
        }
        return sameNumbers;
    }

    public double earningsRate(List<Integer> result, int cost) {
        long sum = 0;
        sum += (long) result.get(3) * LottoEnum.LOTTO_EQUAL_THREE_PRIZE_MONEY.getValue();
        sum += (long) result.get(4) * LottoEnum.LOTTO_EQUAL_FOUR_PRIZE_MONEY.getValue();
        sum += (long) result.get(5) * LottoEnum.LOTTO_EQUAL_FIVE_PRIZE_MONEY.getValue();
        sum += (long) result.get(6) * LottoEnum.LOTTO_EQUAL_SIX_PRIZE_MONEY.getValue();
        sum += (long) result.get(7) * LottoEnum.LOTTO_EQUAL_FIVE_AND_BONUS_PRIZE_MONEY.getValue();
        return (double) sum / cost * 100;
    }
}
