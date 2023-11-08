package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.LottoNumberConstants.*;

public class LottoStatisticsDomain {
    private List<Lotto> purchaseLotto;
    private List<Integer> winningLottoNumber;

    public LottoStatisticsDomain(List<Lotto> purchaseLotto, List<Integer> winningLottoNumber){
        this.purchaseLotto = purchaseLotto;
        this.winningLottoNumber = winningLottoNumber;
    }

    public List<Integer> lottoStatistics() {
        List<Integer> winningNumberCounts = new ArrayList<>();
        for(Lotto lotto : purchaseLotto){
            int winningNumberCount = oneLottoCompare(lotto.oneLottoNumberCopy());
            winningNumberCounts.add(winningNumberCount);
        }
        return winningNumberCounts;
    }

    private int oneLottoCompare(List<Integer> oneLotto) {
        int additionNumber = winningLottoNumber.get(LOTTO_NUMBER_RANGE);
        int count = (int) oneLotto.stream()
                .filter(n -> !n.equals(additionNumber))
                .filter(winningLottoNumber::contains)
                .count();
        if(count == LOTTO_HAVE_ADDITION_NUMBER & isAdditionNumber(oneLotto)){
            return -count;
        }
        return count;
    }

    private boolean isAdditionNumber(List<Integer> oneLotto) {
        return oneLotto.contains(winningLottoNumber.get(LOTTO_NUMBER_RANGE));
    }
}
