package lotto.Service;

import lotto.Domain.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.PrizeMoney;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    List<Lotto> lottos;
    Integer purchasedLottoCount;

    public LottoService(Integer purchaseSum) {
        this.purchasedLottoCount = purchaseSum / 1000;
        this.lottos = createLottos(purchasedLottoCount);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public List<Lotto> createLottos(Integer lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for( int i = 0; i < lottoCount; i++ ){
            Lotto newLotto = createLotto();
            lottos.add(newLotto);
        }

        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms
                .pickUniqueNumbersInRange(1, 45, 6);
        Lotto newLotto = new Lotto(numbers);

        return newLotto;
    }


    public List<Integer> findMatcingCount(Integer purchasedLottoCount,
                                          Integer bonusNumber,
                                          List<Integer> winningNumbers,
                                          List<Lotto> lottos) {
        List<Integer> matchingCount = new ArrayList<>(Stream
                .of(0, 0, 0, 0, 0)
                .collect(Collectors.toList()));

        for( int i = 0; i < purchasedLottoCount; i++ ) {
            List<Integer> lotto = lottos.get(i).getNumbers();
            List<Integer> mergedList = mergeList(lotto, winningNumbers);

            Integer duplicatedNumberCount = 12 - Long
                    .valueOf(mergedList.stream().distinct().count()).intValue();
            matchingCount = calculateMatchingCount(duplicatedNumberCount, matchingCount, lotto, bonusNumber);
        }

        return matchingCount;
    }

    private List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);

        return mergedList;
    }

    private List<Integer> calculateMatchingCount(Integer duplicatedNumberCount,
                                                 List<Integer> matchingCount,
                                                 List<Integer> lotto,
                                                 Integer bonusNumber) {

        if( duplicatedNumberCount >= 3 ) {
            if( duplicatedNumberCount == 5 && lotto.contains(bonusNumber) ) {
                duplicatedNumberCount++;
            }
            else if( duplicatedNumberCount == 6 ){
                duplicatedNumberCount++;
            }

            matchingCount.set(duplicatedNumberCount-3, matchingCount.get(duplicatedNumberCount-3) + 1);
        }
        return matchingCount;
    }

    public double findEarningRate(Integer purchaseSum, List<Integer> matchingCount) {
        double sum = 0.0;
        sum += matchingCount.get(0) * PrizeMoney.FIFTH.getValue();
        sum += matchingCount.get(1) * PrizeMoney.FOURTH.getValue();
        sum += matchingCount.get(2) * PrizeMoney.THIRD.getValue();
        sum += matchingCount.get(3) * PrizeMoney.SECOND.getValue();
        sum += matchingCount.get(4) * PrizeMoney.FIRST.getValue();

        double result = (sum*100)/purchaseSum;

        return result;
    }
}
