package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.logic.Logic;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private List<Lotto> lotteries = new ArrayList<>();

    public void generateLotto(int payment) {
        int count = payment / Logic.LOTTERY_COST;
        for (int i = 0; i < count; i++) {
            lotteries.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    Logic.START_RANGE
                    , Logic.END_RANGE
                    , Logic.NUMBER_COUNT))
            );
        }
    }

    public int[] getTotalScore(List<Integer> winningNumber, int bonusNumber){
        int[] totalScore = new int[5];
        for (Lotto lottery : lotteries) {
            int[] score = lottery.getScore(winningNumber, bonusNumber);
            if (score[0] == 3) {
                totalScore[0] ++;
            }else if (score[0] == 4) {
                totalScore[1] ++;
            }else if (score[0] == 5 && score[1] == 0) {
                totalScore[2] ++;
            }else if (score[0] == 5 && score[1] == 1) {
                totalScore[3] ++;
            }else if (score[0] == 7) {
                totalScore[4] ++;
            }
        }
        return totalScore;
    }


    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
