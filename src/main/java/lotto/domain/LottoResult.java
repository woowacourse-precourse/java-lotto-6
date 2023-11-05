package lotto.domain;

import static lotto.domain.LottoPrizeStatus.getSatisfiedContainsStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.ErrorMessages;

public class LottoResult {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoResult(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (containDuplicateNumber(winningLotto, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_BONUS_NUMBER_ERROR.getMessage());
        }
    }

    private boolean containDuplicateNumber(Lotto winningLotto, int bonusNumber) {
        return winningLotto.getNumbers()
                .contains(bonusNumber);
    }

    public Map<LottoPrizeStatus, Integer> mappingLottoResult(List<Lotto> issuedLottos) {
        Map<LottoPrizeStatus, Integer> resultMap = getResultMap();
        for (Lotto issuedLotto : issuedLottos) {
            int matchCount = winningLotto.calculateMatchCount(issuedLotto);
            boolean isContainBonusNum = checkContainBonusNumber(issuedLotto);
            LottoPrizeStatus lottoStatus = getSatisfiedContainsStatus(matchCount, isContainBonusNum);
            if (lottoStatus != null) {
                resultMap.put(lottoStatus, resultMap.get(lottoStatus) + 1);
            }
        }
        return resultMap;
    }

    private boolean checkContainBonusNumber(Lotto issuedLotto) {
        return issuedLotto.getNumbers().contains(bonusNumber);
    }

    private Map<LottoPrizeStatus, Integer> getResultMap() {
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
