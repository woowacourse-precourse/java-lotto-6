package lotto.model.service;

import lotto.model.domain.Lotto;
import lotto.model.domain.Referee;

import java.util.List;

import static lotto.model.domain.Rank.*;
import static lotto.util.constant.Constant.INITIALIZE_NUMBER;
import static lotto.util.constant.Constant.PER_THOUSAND;

public class RefereeService {

    public void calculateLottoResult(Referee referee, List<Lotto> lottoList) {
        List<Integer> winningNumbers = referee.getWinningNumbers();
        int bonusNumber = referee.getBonusNumber();

        for (Lotto lotto : lottoList) {
            int hitNumberCount = INITIALIZE_NUMBER;
            boolean isHitBonusNumber = false;
            int rank = INITIALIZE_NUMBER;
            List<Integer> numbers = lotto.getNumbers();
            hitNumberCount = getHitNumberCount(winningNumbers, hitNumberCount, numbers);
            isHitBonusNumber = isHitBonusNumber(bonusNumber, isHitBonusNumber, numbers);
            rank = getRank(hitNumberCount, isHitBonusNumber, rank);

            referee.increaseCountForRank(rank);
            referee.calculateLottoBenefit(lottoList.size() * PER_THOUSAND);
        }
    }

    public int getRank(int hitNumberCount, boolean isHitBonusNumber, int rank) {
        if (hitNumberCount == FIRST.getHitCount()) {
            rank = FIRST.getRank();
        } else if (hitNumberCount == SECOND.getHitCount() && isHitBonusNumber) {
            rank = SECOND.getRank();
        } else if (hitNumberCount == THIRD.getHitCount()) {
            rank = THIRD.getRank();
        } else if (hitNumberCount == FOURTH.getHitCount()) {
            rank = FOURTH.getRank();
        } else if (hitNumberCount == FIFTH.getHitCount()) {
            rank = FIFTH.getRank();
        }
        return rank;
    }

    public boolean isHitBonusNumber(int bonusNumber, boolean isHitBonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            isHitBonusNumber = true;
        }
        return isHitBonusNumber;
    }

    public int getHitNumberCount(List<Integer> winningNumbers, int hitNumberCount, List<Integer> numbers) {
        for (int i = 0; i < 6; i++) {
            if (winningNumbers.contains(numbers.get(i))) {
                hitNumberCount++;
            }
        }
        return hitNumberCount;
    }
}
