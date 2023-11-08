package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstant.*;

public class WinningEnquiry {
    private final List<Integer> statics;
    public WinningEnquiry() {
        statics = new ArrayList<Integer>();
        initStatics();
    }

    private void initStatics() {
        for(int i = 0 ; i < RANK_SIZE.getNumber() ; i++) {
            statics.add(0);
        }
    }

    private void resetStatics() {
        for(int i = 0 ; i < RANK_SIZE.getNumber() ; i++) {
            statics.set(i, 0);
        }
    }

    public List<Integer> getStatics() {
        return statics;
    }

    public void calculateWinningStatics(List<Lotto> lottos, LottoWinning lottoWinning) {
        for (Lotto _lotto: lottos) {
            int same = _lotto.compare(lottoWinning.getWinningNumber());
            if (same >= 3) {
                statics.set(same -3, statics.get(same -3)+1);
            }
        }
    }

    public double calculateRateOfReturn(int money) {
        double rateOfReturn = ((statics.get(0) * THREE_WINNINGS.getNumber())
                + (statics.get(1) * FOUR_WINNINGS.getNumber())
                + (statics.get(2) * FIVE_WINNINGS.getNumber())
                + (statics.get(3) * SIX_WINNINGS.getNumber())
                + (statics.get(4) * FIVE_BONUS_WINNINGS.getNumber())
        ) / (double)money * 100;
        return Math.round((rateOfReturn * 10))/ 10.0;
    }
}
