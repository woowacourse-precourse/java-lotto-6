package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlayLotto {

    public static int MIN_WIN_CONDITION = 3;
    private final Map<Rank, Integer> lottoResult = new HashMap<>();
    private final Set<Integer> prizeNumbers;
    private final int bonusNumber;

    public PlayLotto(Set<Integer> prizeNumbers, int bonusNumber) {
        this.prizeNumbers = prizeNumbers;
        validateBonusNuber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void lottoResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            putResult(lotto);
        }
    }

    private void putResult(Lotto lotto) {
        int count = lotto.countCorrectLottoNumber(prizeNumbers);
        if (count < MIN_WIN_CONDITION) {
            return;
        }
        Rank rank = Rank.of(count, lotto.contains(bonusNumber));
        lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
    }

    private void validateBonusNuber(int bonusNumber) {
        Lotto.validateSingleNumberRange(bonusNumber);
        if (prizeNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복 값으로 설정할 수 없습니다.");
        }
    }

}
