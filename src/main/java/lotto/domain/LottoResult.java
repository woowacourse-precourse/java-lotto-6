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
        return winningLotto.checkContainBonusNumber(bonusNumber);
    }

    public Map<LottoPrize, Integer> mappingPrizeResult(List<Lotto> issuedLottos) {
        Map<LottoPrize, Integer> prizeResult = getPrizeResult();
        calculatePrizeResult(prizeResult, issuedLottos);
        return prizeResult;
    }

    private void calculatePrizeResult(Map<LottoPrize, Integer> prizeResult, List<Lotto> issuedLottos) {
        for (Lotto issuedLotto : issuedLottos) {
            int matchCount = winningLotto.calculateMatchCount(issuedLotto);
            boolean isContainBonusNumber = issuedLotto.checkContainBonusNumber(bonusNumber);
            LottoPrize status = LottoPrize.getSatisfiedConditionsStatus(matchCount, isContainBonusNumber);
            if (status != null) {
                prizeResult.put(status, prizeResult.get(status) + ADD_COUNT);
            }
        }
    }

    private Map<LottoPrize, Integer> getPrizeResult() {
        final Map<LottoPrize, Integer> resultMap = new HashMap<>();
        Arrays.stream(LottoPrize.values())
                .forEach((status) -> resultMap.put(status, 0));
        return resultMap;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
