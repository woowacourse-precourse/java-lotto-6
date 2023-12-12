package lotto.service;

import java.util.List;
import lotto.entity.Lotto;
import lotto.entity.LottoScore;

public class ScoreService {

    public LottoScore lottoScore(List<Integer> results, List<Lotto> lottos, int bonusNumber){
        LottoScore lottoScore = new LottoScore();
        boolean bonus = false;

        for (Lotto lotto : lottos) {
            int matchingNumbers = countMatchingNumbers(lotto, results, bonusNumber, bonus);
            addMatchingNumbers(lottoScore, matchingNumbers, bonus);
        }

        return lottoScore;

    }

    private int countMatchingNumbers(Lotto lotto, List<Integer> results, int bonusNumber, boolean bonus) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int matchingNumbers = 0;

        for (int number : lottoNumbers) {
            if (results.contains(number)) {
                matchingNumbers++;
            }
            if(number == bonusNumber){
                bonus = true;
            }
        }

        return matchingNumbers;
    }

    public void addMatchingNumbers(LottoScore result, int matchNumbers, boolean bonus){
        if(matchNumbers == 3){
            addCorrect3(result);
        }
        if(matchNumbers == 4){
            addCorrect4(result);
        }
        if(matchNumbers == 5 && !bonus){
            addCorrect5(result);
        }
        if(matchNumbers == 5 && bonus){
            addCorrect5Bonus(result);
        }
        if(matchNumbers == 6){
            addCorrect6(result);
        }
    }

    private void addCorrect3(LottoScore result) {
        int score = result.getCorrect3() +1;
        result.setCorrect3(score);
    }

    private void addCorrect4(LottoScore result) {
        int score = result.getCorrect4() +1;
        result.setCorrect4(score);
    }

    private void addCorrect5(LottoScore result) {
        int score = result.getCorrect5() +1;
        result.setCorrect5(score);
    }

    private void addCorrect5Bonus(LottoScore result) {
        int score = result.getCorrect5Bonus() +1;
        result.setCorrect5Bouns(score);
    }

    private void addCorrect6(LottoScore result) {
        int score = result.getCorrect6() +1;
        result.setCorrect6(score);
    }


}
