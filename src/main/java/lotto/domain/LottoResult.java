package lotto.domain;

import java.util.*;

import lotto.util.ErrorMessages;

public class LottoResult {
    private final Lotto winningLotto;
    private final int bonusNumber;

    private static final int ADD_COUNT = 1;
    public LottoResult(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (isContainDuplicateNumber(winningLotto, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_BONUS_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isContainDuplicateNumber(Lotto winningLotto, int bonusNumber) {
        return winningLotto.getNumbers()
                .contains(bonusNumber);
    }

    public Map<LottoPrizeStatus, Integer> mappingPrizeResult(List<Lotto> issuedLottos) {
        Map<LottoPrizeStatus, Integer> prizeResult = getPrizeResult();
        calculatePrizeResult(prizeResult, issuedLottos);
        return prizeResult;
    }

    private void calculatePrizeResult(Map<LottoPrizeStatus, Integer> prizeResult, List<Lotto> issuedLottos) {
        for (Lotto issuedLotto : issuedLottos) {
            int matchCount = winningLotto.calculateMatchCount(issuedLotto);
            boolean isContainBonusNumber = checkContainBonusNumber(issuedLotto);
            LottoPrizeStatus status = LottoPrizeStatus.getSatisfiedContainsStatus(matchCount, isContainBonusNumber);
            if (status != null) {
                prizeResult.put(status, prizeResult.get(status) + ADD_COUNT);
            }
        }
    }

    private boolean checkContainBonusNumber(Lotto issuedLotto) {
        return issuedLotto.getNumbers().contains(bonusNumber);
    }

    private Map<LottoPrizeStatus, Integer> getPrizeResult() {
        final Map<LottoPrizeStatus, Integer> resultMap = new HashMap<>();
        Arrays.stream(LottoPrizeStatus.values())
                .forEach((status) -> resultMap.put(status, 0));
        return resultMap;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
