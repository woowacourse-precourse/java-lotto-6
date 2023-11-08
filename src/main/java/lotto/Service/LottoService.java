package lotto.Service;

import lotto.Domain.Lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private static final Integer LOTTO_NUMBER_LENGTH = 6;

    List<Lotto> lottos;

    List<Integer> winningNumbers;
    Integer bonusNumber;
    double earningReate;
    List<Integer> matchingCount;

    Integer purchasedLottoCount;


    public LottoService(Integer purchaseSum){

        this.purchasedLottoCount = purchaseSum / 1000;
        this.lottos = createLottos(purchasedLottoCount);
        this.matchingCount = new ArrayList<>(
                Stream.of(0, 0, 0, 0, 0)
                        .collect(Collectors.toList())
        );
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }




    public List<Lotto> createLottos(Integer lottoCount){

        List<Lotto> lottos = new ArrayList<>();
        for( int i = 0; i < lottoCount; i++ ){
            Lotto newLotto = createLotto();
            lottos.add(newLotto);
        }
        return lottos;
    }

    private Lotto createLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//        Collections.sort(numbers);
        Lotto newLotto = new Lotto(numbers);

        return newLotto;
    }


    public List<Integer> findMatcingCount() {

        for( int i = 0; i < this.purchasedLottoCount; i++ ){
            List<Integer> mergedList = new ArrayList<>();
            List<Integer> lotto = this.lottos.get(i).getNumbers();
            mergedList.addAll(lotto);
            mergedList.addAll(this.winningNumbers);

            Integer duplicatedNumberCount = 12 - Long.valueOf(mergedList.stream().distinct().count()).intValue();

            if(duplicatedNumberCount >= 3){
                if(duplicatedNumberCount == 5 && lotto.contains(this.bonusNumber)){
                    duplicatedNumberCount++;
                }
                else if(duplicatedNumberCount == 6){
                    duplicatedNumberCount++;
                }

                System.out.println(duplicatedNumberCount);
                this.matchingCount.set(duplicatedNumberCount-3, this.matchingCount.get(duplicatedNumberCount-3) + 1);
            }
        }

        return this.matchingCount;
    }

    public double findEarningRate(Integer purchaseSum) {

        double sum = 0.0;
        sum += this.matchingCount.get(0) * 5000;
        sum += this.matchingCount.get(1) * 50000;
        sum += this.matchingCount.get(2) * 1500000;
        sum += this.matchingCount.get(3) * 30000000;
        sum += this.matchingCount.get(4) * 2000000000;


        double result = sum/purchaseSum;

        return result;
    }
}
