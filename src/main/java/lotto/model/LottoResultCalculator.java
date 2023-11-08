package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Class : 당첨 로또 계산 클래스
 */
public class LottoResultCalculator {

    private final Lotto lotto;
    private final int bonusNumber;

    public LottoResultCalculator(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoResult> getLottoResults(List<Lotto> purchasedLottoList) {
        List<LottoResult> lottoResultList = new ArrayList<>();
        Map<LottoRank, Integer> rankCountMap = new HashMap<>();

        purchasedLottoList.forEach(pl -> {
            LottoRank rank = LottoRank.findRank(getSameLottoCount(pl), isContainBonusNumber(pl));
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        });

        LottoRank.getAllRank().forEach(r -> {
            lottoResultList.add(new LottoResult(r, rankCountMap.getOrDefault(r, 0)));
        });

        return lottoResultList;
    }

    private int getSameLottoCount(Lotto lotto) {
        List<Integer> resultList = new ArrayList<>(this.lotto.getNumbers());

        List<Integer> duplicateList = new ArrayList<>(lotto.getNumbers());
        duplicateList.retainAll(resultList);
        return duplicateList.size();
    }

    private boolean isContainBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
