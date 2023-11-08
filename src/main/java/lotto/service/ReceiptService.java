package lotto.service;

import static lotto.configurations.SettingValues.*;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import lotto.repository.ReceiptRepository;
import lotto.repository.LottoRepository;


public class ReceiptService {
    LottoRepository lottoRepository;
    ReceiptRepository receiptRepository;

    private static class SingletonLottoScoringService {
        private static final ReceiptService LOTTO_SCORING_SERVICE = new ReceiptService();
    }

    public static ReceiptService getInstance() {
        return SingletonLottoScoringService.LOTTO_SCORING_SERVICE;
    }

    private ReceiptService() {
        lottoRepository = LottoRepository.getInstance();
        receiptRepository = ReceiptRepository.getInstance();
    }

    public void rankUserLottos(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        lottoRepository.resetIndex();
        while (lottoRepository.isRemainUserLotto()) {

            Lotto userLotto = lottoRepository.getNextUserLotto();

            Integer ranking = scoreALotto(winningNumbers, bonusNumber, userLotto);

            receiptRepository.increaseNumberOfRanking(ranking);
        }
    }

    public Integer[] getNumbersOfRanking() {
        Integer[] numbersOfRanking = new Integer[]{0, 0, 0, 0, 0, 0};
        for (int i = FAIL.get(); i <= FIFTH.get(); i++) {
            numbersOfRanking[i] = receiptRepository.getNumberOfRanking(i);
        }
        return numbersOfRanking;
    }

    public Double getProfitRatio() {
        Long totalRewards = receiptRepository.getTotalRewards();
        Long numberOfLotto = (long) lottoRepository.getNumberOfLotto();
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
