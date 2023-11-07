package lotto.service;

import static lotto.configurations.SettingValues.*;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.UserLottos;
import lotto.model.WinningNumbers;


public class LottoScoringService {
    private static class SingletonLottoScoringService {
        private static final LottoScoringService LOTTO_SCORING_SERVICE = new LottoScoringService();
    }

    public static LottoScoringService getInstance() {
        return SingletonLottoScoringService.LOTTO_SCORING_SERVICE;
    }

    private LottoScoringService() {
    }

    public Integer[] rankUserLottos(WinningNumbers winningNumbers, BonusNumber bonusNumber, UserLottos userLottos) {
        Integer[] numberOfRankings = {0, 0, 0, 0, 0, 0};

        userLottos.resetIndex();
        while (userLottos.isRemainUserLotto()) {
            Lotto userLotto = userLottos.getNextUserLotto();

            Integer ranking = scoreALotto(winningNumbers, bonusNumber, userLotto);

            numberOfRankings[ranking]++;
        }
        return numberOfRankings;
    }

    private Integer scoreALotto(WinningNumbers winningNumbers, BonusNumber bonusNumber, Lotto lotto) {
        Integer ranking;

        Integer winningPoint = calculatePoint(winningNumbers, lotto);
        Boolean bonusPoint = checkBonusPoint(bonusNumber, lotto);

        ranking = rank(winningPoint, bonusPoint);

        return ranking;
    }

    private Integer calculatePoint(WinningNumbers winningNumbers, Lotto lotto) {
        Integer winningPoint = 0;

        for (int i = 0; i < SIZE_OF_LOTTO.get(); i++) {
            Integer number = lotto.getValue(i);
            if (winningNumbers.contains(number)) {
                winningPoint++;
            }
        }

        return winningPoint;
    }

    private Boolean checkBonusPoint(BonusNumber bonusNumber, Lotto lotto) {
        for (int i = 0; i < SIZE_OF_LOTTO.get(); i++) {
            Integer number = lotto.getValue(i);
            if (bonusNumber.equals(number)) {
                return true;
            }
        }
        return false;
    }

    private Integer rank(Integer winningPoint, Boolean bonusPoint) {
        if (winningPoint == POINT_OF_FIRST.get()) {
            return FIRST.get();
        }

        if (winningPoint == POINT_OF_SECOND.get() && bonusPoint) {
            return SECOND.get();
        }

        if (winningPoint == POINT_OF_THIRD.get()) {
            return THIRD.get();
        }

        if (winningPoint == POINT_OF_FOURTH.get()) {
            return FOURTH.get();
        }

        if (winningPoint == POINT_OF_FIFTH.get()) {
            return FIFTH.get();
        }
        return FAIL.get();
    }
}
