package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.Rank;

public class GameController {

    void buyLotto(int money) {
        int count = money / 1000;

        Lotto[] lottos = new Lotto[count];
        Generator generator = new Generator();

        for(Lotto lotto : lottos) {
            List<Integer> lottoNumbers = generator.lottoNumbers();
            lotto = new Lotto(lottoNumbers);
        }

    }

    int matchingWinNumber(List<Integer> lotto, List<Integer> winNumber, int bonus) {
        int matchCnt = 0;

        for(int num : lotto) {
            if(winNumber.contains(num)) {
                matchCnt++;
            }
        }

        if(lotto.contains(bonus)) {
            matchCnt++;
        }

        return matchCnt;
    }
    Map<Rank, Integer> getResult(Lotto[] lottos, List<Integer> winNumber, int bonus) {
        Map<Rank, Integer> result = Rank.initResultRepo();

        for(Lotto lotto : lottos) {
            Rank rank;
            int matchCnt = matchingWinNumber(lotto.getNumbers(), winNumber, bonus);
            rank = Rank.result(matchCnt, lotto.getNumbers().contains(bonus));

            result.replace(rank, result.get(rank) + 1);
        }

        return result;
    }

    int calculatePrize(Map<Rank, Integer> result) {
        return Rank.calculatePrize(result);
    }

    double calculateProfitRate(int cost, int totalPrize) {
        return (double)totalPrize / (double)cost * 100;
    }
}
