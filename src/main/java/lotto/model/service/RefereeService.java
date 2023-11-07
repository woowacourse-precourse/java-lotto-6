package lotto.model.service;

import lotto.model.domain.Lotto;
import lotto.model.domain.Referee;

import java.util.List;

public class RefereeService {

    public Referee calculateLottoResult(Referee referee, List<Lotto> lottoList) {
        List<Integer> winningNumbers = referee.getWinningNumbers();
        int bonusNumber = referee.getBonusNumber();

        for (Lotto lotto : lottoList) {
            int hitNumberCount = 0;
            boolean isHitBonusNumber = false;
            int rank = 0;
            List<Integer> numbers = lotto.getNumbers();
            for (int i = 0; i < 6; i++) {
                if (winningNumbers.contains(numbers.get(i))) {
                    hitNumberCount++;
                }
            }
            if (numbers.contains(bonusNumber)) {
                isHitBonusNumber = true;
            }
            if (hitNumberCount == 6) {
                rank = 1;
            } else if (hitNumberCount == 5 && isHitBonusNumber) {
                rank = 2;
            } else if (hitNumberCount == 5) {
                rank = 3;
            } else if (hitNumberCount == 4) {
                rank = 4;
            } else if (hitNumberCount == 3) {
                rank = 5;
            }

            referee.increaseCountForRank(rank);
            referee.calculateLottoBenefit(lottoList.size() * 1000);
        }
        return referee;
    }
}
