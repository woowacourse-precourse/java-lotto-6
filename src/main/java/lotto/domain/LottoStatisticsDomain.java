package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

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
        int count = (int) oneLotto.stream()
                .filter(winningLottoNumber::contains)
                .count();
        if(count == 6){
            if (oneLotto.contains(winningLottoNumber.get(winningLottoNumber.size() - 1))) {
                return -count;
            }
        }
        return count;
    }
}
