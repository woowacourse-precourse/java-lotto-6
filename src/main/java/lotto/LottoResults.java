package lotto;

import java.util.List;
import java.util.ArrayList;
public class LottoResults {
    public static List<Integer> getLottoResults(List<Lotto> Lotteries, Lotto targetLotto, int bonusNumber){
        List<Integer> lottoResults = new ArrayList<>();

        lottoResults.add(getFirstResult(Lotteries, targetLotto));
        lottoResults.add(getSecondResult(Lotteries, targetLotto, bonusNumber));
        lottoResults.add(getThirdResult(Lotteries, targetLotto, bonusNumber));
        lottoResults.add(getFourthResult(Lotteries, targetLotto));
        lottoResults.add(getFifthResult(Lotteries, targetLotto));

        return lottoResults;
    }

    public static int getFirstResult(List<Lotto> Lotteries, Lotto targetLotto) {
        int numberOfMatch = 0;

        return numberOfMatch;
    }

    public static int getSecondResult(List<Lotto> Lotteries, Lotto targetLotto, int bonusNumber) {
        int numberOfMatch = 0;

        return numberOfMatch;
    }

    public static int getThirdResult(List<Lotto> Lotteries, Lotto targetLotto, int bonusNumber) {
        int numberOfMatch = 0;

        return numberOfMatch;
    }

    public static int getFourthResult(List<Lotto> Lotteries, Lotto targetLotto) {
        int numberOfMatch = 0;

        return numberOfMatch;
    }

    public static int getFifthResult(List<Lotto> Lotteries, Lotto targetLotto) {
        int numberOfMatch = 0;

        return numberOfMatch;
    }
}
