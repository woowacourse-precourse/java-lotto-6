package lotto.Function;

import lotto.Domain.LottoTickets;
import lotto.Domain.Prize;
import lotto.Domain.PrizeBonusNumber;
import lotto.Lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PrizeLottoCompare {
    private final Map<Prize, Integer> prizeLottoCompare;
    //랭킹 저장
    public PrizeLottoCompare() {
        prizeLottoCompare = new EnumMap<Prize, Integer>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> prizeLottoCompare.put(prize, 0));
    }
    //랭킹 계산
    public void calculatePrizeLottoCompare(PrizeBonusNumber prizeBonusNumber, LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            Prize prize = Prize.getPrize(lotto.getMatchLottoNumber(prizeBonusNumber), lotto.isContain(prizeBonusNumber.getBonusNumber()));
            updatePrizeCount(prize);
        }
    }

    private void updatePrizeCount(Prize prize) {
        prizeLottoCompare.put(prize, prizeLottoCompare.get(prize) + 1);
    }

    public Integer getPrizeCount(Prize prize) {
        return prizeLottoCompare.get(prize);
    }
}
