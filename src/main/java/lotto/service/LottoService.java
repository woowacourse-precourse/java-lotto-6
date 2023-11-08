package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.entity.Lotto;
import lotto.entity.LottoScore;

public class LottoService {

    public Integer getCount(int money){
        if(money % 1000 > 0){
            throw new IllegalArgumentException("1000으로 나누어 떨어지는 수를 입력해 주세요.");
        }
        return money / 1000;
    }

    public List<Lotto> lottoGenerate(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .map(lotto -> new Lotto(
                        lotto.getNumbers().stream()
                                .sorted()
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

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
            int score = result.getCorrect3() +1;
            result.setCorrect3(score);
        }
        if(matchNumbers == 4){
            int score = result.getCorrect4() +1;
            result.setCorrect4(score);
        }
        if(matchNumbers == 5 && !bonus){
            int score = result.getCorrect5() +1;
            result.setCorrect5(score);
        }
        if(matchNumbers == 5 && bonus){
            int score = result.getCorrect5Bonus() +1;
            result.setCorrect5Bouns(score);
        }
        if(matchNumbers == 6){
            int score = result.getCorrect6() +1;
            result.setCorrect6(score);
        }
    }

    public Double rateReturn(LottoScore lottoScore, int money){
        int totalWinnings = (lottoScore.getCorrect3() * 5000) + (lottoScore.getCorrect4() * 50000)
                + (lottoScore.getCorrect5() * 1500000) + (lottoScore.getCorrect5Bonus() * 30000000)
                + (lottoScore.getCorrect6() * 2000000000);

        return ((double) totalWinnings - money) / money;
    }

}
