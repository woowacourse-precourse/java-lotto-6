package lotto.model;

import java.util.List;
import lotto.util.Validator;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.numbers = lotto.getLottoNumbers();
        Validator.validateBonusNumber(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    /**
     * Description: 몇 개의 번호가 일치하는지 반환
     */
    public int getMatchCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(this::isContain)
                .count();
    }

    /**
     * Description: 매개변수로 받은 LottoNumber가 당첨 번호 안에 속하는지 여부
     */
    private boolean isContain(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    /**
     * Description: 매개변수로 받은 Lotto 안에 보너스 번호가 있는지 여부
     */
    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusNumber);
    }
}
