package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.util.Parser.stringToInt;
import static lotto.util.Parser.stringToList;

public class WinningNumbers {
    Lotto winningLotto;
    int bonusNumber;

    public WinningNumbers(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        validateBonusNumber(lotto,bonusNumber);
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLottos(Lottos userLottos) {
        LottoResult lottoResult = new LottoResult();
        userLottos.getLottos()
                .forEach(lotto -> lottoResult.addResult(checkLotto(lotto)));
        return lottoResult;
    }

    private Rank checkLotto(Lotto userLotto) {
        return Rank.decideRank(checkCollectCount(userLotto), checkBonusNumber(userLotto));
    }
    private void validateBonusNumber(Lotto lotto, int bonusNumber) throws IllegalArgumentException{
        validateNumberBoundry(bonusNumber);
        validateDuplication(lotto, bonusNumber);
    }

    private void validateNumberBoundry(int bonusNumber) throws IllegalArgumentException{
        if(bonusNumber<1 || bonusNumber>45)
            throw new IllegalArgumentException();
    }

    private void validateDuplication(Lotto lotto, int bonusNumber) throws IllegalArgumentException{
        if(lotto.getNumbers().contains(bonusNumber))
            throw new IllegalArgumentException();
    }

    private int checkCollectCount(Lotto userLotto) {
        return (int)winningLotto.getNumbers().stream()
                .filter(userLotto::hasNumber)
                .count();
    }

    private boolean checkBonusNumber(Lotto userLotto) {
        return userLotto.hasNumber(bonusNumber);
    }
}
