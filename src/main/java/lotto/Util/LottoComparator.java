package lotto.Util;

import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoNumber;

public class LottoComparator {

    private final Lotto winLotto;

    public LottoComparator(Lotto winLotto) {
        this.winLotto = winLotto;
    }

    public int compareLotto(Lotto userLotto) {
        List<Integer> winLottoNumbers = winLotto.getNumbers();
        List<Integer> userLottoNumbers = userLotto.getNumbers();
        int count = 0;

        for (int lottoNumber : userLottoNumbers) {
            if (winLottoNumbers.contains(lottoNumber)) {
                count++;
            }
        }

        return count;
    }

    public boolean compareBonusNumber(Lotto userLotto, LottoNumber bonusNumber) {
        // 보너스 번호도 결국 winLotto에 포함되기 때문에 유저의 로또 번호에서 찾는다.
        List<Integer> userLottoNumbers = userLotto.getNumbers();
        return userLottoNumbers.contains(bonusNumber.getLottoNumber());
    }
}
