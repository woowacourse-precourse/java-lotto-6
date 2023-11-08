package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import java.util.*;

public class Application {
    private static final int UnitCost = 1000;
    public static List<Lotto> lottoGenerator(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < lottoCount) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
    public static List<Integer> correctCounting(List<Lotto> lottos, Lotto winningLottoNumber){
        int correctCount = 0;
        List<Integer> correctCounts = new ArrayList<>();
        for(Lotto l:lottos) {
            List<Integer> lottosTemp = new ArrayList<>(l.getter());
            for (int i = 0; i < 6; i++) {
                if (lottosTemp.contains(winningLottoNumber.getter().get(i))) {
                    correctCount += 1;
                }
            }
            correctCounts.add(correctCount);
            correctCount = 0;
        }
        return correctCounts;
    }
    public static List<Integer> bonusNumberCheck(List<Lotto> lottos, List<Integer> correctCounts, int bonusNumber){
        for(Lotto l:lottos) {
            List<Integer> lottosTemp = new ArrayList<Integer>(l.getter());
            for (int i = 0; i < correctCounts.size(); i++) {
                if(correctCounts.get(i) == 5 && lottosTemp.contains(bonusNumber)){
                    correctCounts.set(i, 55);

                }
            }
        }
        return correctCounts;
    }
    public static void main(String[] args) {
        int purchasePrice = Get.purchasePrice();

        int lottoCount = purchasePrice / UnitCost;
        List<Lotto> lottos = lottoGenerator(lottoCount);

        System.out.print(lottoCount);
        Print.message(1);
        Print.sortedLottoNumber(lottos);

        Lotto winningLottoNumber;
        while(true){
            Print.message(2);
            winningLottoNumber = new Lotto(Get.winningNumber());
            if(winningLottoNumber.getter() != null){
                break;
            }
        }

        int bonusNumber = Get.bonusNumber(winningLottoNumber);

        List<Integer> correctCounts = correctCounting(lottos, winningLottoNumber);
        List<Integer> correctCountingResult = bonusNumberCheck(lottos, correctCounts, bonusNumber);

        Print.message(4);
        Print.message(5);
        float earningRate = ((float) Print.LottoResult(correctCountingResult) / purchasePrice) * 100;
        Print.roundEarningRate(earningRate);
    }
}
