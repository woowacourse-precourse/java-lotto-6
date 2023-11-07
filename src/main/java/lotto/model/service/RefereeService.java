package lotto.model.service;

import lotto.model.domain.Lotto;
import lotto.model.domain.Referee;

import java.util.List;

public class RefereeService {

    public Referee calculateLottoResult(Referee referee, List<Lotto> lottoList) {
        List<Integer> winningNumbers = referee.getWinningNumbers();
        int bonusNumber = referee.getBonusNumber();

        for(Lotto lotto : lottoList) {
            int hitNumberCount = 0;
            boolean isHitBonusNumber = false;
            int rank = 0;
            for(int i = 0; i < 6; i++) {
                List<Integer> numbers = lotto.getNumbers();
                if(numbers.get(i).equals(winningNumbers.get(i))) {
                    hitNumberCount++;
                }
                if(numbers.get(i).equals(bonusNumber)) {
                    isHitBonusNumber = true;
                }
            }
            if(hitNumberCount == 6) {
                rank = 1;
            } else if(hitNumberCount == 5 && isHitBonusNumber) {
                rank = 2;
            } else if(hitNumberCount == 5) {
                rank = 3;
            } else if(hitNumberCount == 4) {
                rank = 4;
            } else if(hitNumberCount == 3) {
                rank = 5;
            }
            referee.increaseCountForRank(rank);
        }
        return referee;
    }
}
