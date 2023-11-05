package lotto.service;

import static lotto.configurations.SettingValues.*;

import java.util.ArrayList;
import java.util.List;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;

public class LottoScoringService {
    WinningLotto winningLotto;
    List<Integer> userLottoRankings;

    LottoScoringService(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }
    public void scoreUserLottos(List<UserLotto> userLottoList){
        userLottoRankings = new ArrayList<>();
        for(UserLotto userLotto : userLottoList){
            Integer ranking = scoreALotto(userLotto);
            //validate(ranking);
            userLottoRankings.add(ranking);
        }
    }
    private Integer scoreALotto(UserLotto userLotto) {
        Integer ranking;

        List<Integer> userNumbers = userLotto.getLottoNumbers();

        Integer winningPoint = calculatePoint(userNumbers);
        Boolean bonusPoint = checkBonusPoint(userNumbers);

        // validate winning point
        // validate bonus point

        ranking = rank(winningPoint, bonusPoint);
        return ranking;
    }

    private Integer calculatePoint(List<Integer> userNumbers) {
        Integer winningPoint = 0;
        for (Integer number : userNumbers) {
            if (winningLotto.contains(number)) {
                winningPoint++;
            }
        }
        return winningPoint;
    }

    private Boolean checkBonusPoint(List<Integer> userNumbers) {
        return userNumbers.contains(winningLotto.getBonusNumber());
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
