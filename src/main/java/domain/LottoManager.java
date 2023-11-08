package domain;

import static domain.LottoInfoNumbers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoManager {

    public void purchaseLotto(User user) {
        int count = user.getPurchaseAmount() / LOTTERY_TICKET_PRICE;
        for (int i = 0; i < count; i++) {
            Lotto lotto = generateLottoNumbers();
            user.purchaseLotto(lotto);
        }
    }

    private Lotto generateLottoNumbers() {
        List<Integer> randoms = Utils.generateRandomNumbers(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_TOTAL_NUMBER);
        List<Integer> lottoNumbers = new ArrayList<>(randoms);
        return new Lotto(lottoNumbers);
    }

    private int countMatchLottoNumbers(LottoValidation lottoValidation, Lotto lotto) {
        return Utils.countMatchNumbers(lottoValidation.getWinningNumbers(), lotto.getNumbers());
    }

    private boolean hasBonusNumber(LottoValidation lottoValidation, Lotto lotto) {
        return lotto.getNumbers().contains(lottoValidation.getBonusNumber());
    }

    public void checkUserLotto(User user, LottoValidation lottoValidation) {

    }

}
