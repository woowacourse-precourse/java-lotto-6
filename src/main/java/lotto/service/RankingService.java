package lotto.service;

import static lotto.configurations.SettingValues.*;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import lotto.repository.RankingRepository;
import lotto.repository.LottoRepository;


public class RankingService {
    LottoRepository lottoRepository;
    RankingRepository rankingRepository;

    private static class SingletonLottoScoringService {
        private static final RankingService LOTTO_SCORING_SERVICE = new RankingService();
    }

    public static RankingService getInstance() {
        return SingletonLottoScoringService.LOTTO_SCORING_SERVICE;
    }

    private RankingService() {
        lottoRepository = LottoRepository.getInstance();
        rankingRepository = RankingRepository.getInstance();
    }

    public void rankLottos(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (int index = 0; index < lottoRepository.findNumberOfUserLotto(); index++) {
            Lotto userLotto = lottoRepository.findUserLottoByIndex(index);

            Integer ranking = scoreALotto(winningNumbers, bonusNumber, userLotto);

            rankingRepository.increaseNumberOfRanking(ranking);
        }
    }

    public Integer[] getNumbersOfRanking() {
        Integer[] numbersOfRanking = new Integer[]{0, 0, 0, 0, 0, 0};
        for (int i = FAIL.get(); i <= FIFTH.get(); i++) {
            numbersOfRanking[i] = rankingRepository.findNumberOfRankingByRanking(i);
        }
        return numbersOfRanking;
    }

    public Double getProfitRatio() {
        Long totalRewards = rankingRepository.findTotalRewards();
        Long numberOfLotto = (long) lottoRepository.findNumberOfUserLotto();
        Long purchaseAmount = numberOfLotto * (long) PRICE_OF_LOTTO.get();

        return (double) totalRewards / (double) purchaseAmount;
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
