package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.Result;
import lotto.LottoGenerator;
import lotto.Util.Validation;
import lotto.View.InputView;


public class LottoController {

    private static final int LOTTO_PRICE_PER_GAME = 1000;
    private static final int HIT_TICK = 1;
    private int purchasedAmount = 0;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winnerLotto;
    private int bonusNumber;

    private void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private void setWinnerLotto(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    private int calcAvailableAmount(int availableMoney) {
        return availableMoney / LOTTO_PRICE_PER_GAME;
    }

    private void purchaseLotto() {
        int availableMoney = InputView.getAvailableMoney();
        this.purchasedAmount = calcAvailableAmount(availableMoney);
    }

    private void publishLotto() {
        for (int i = 0; i < this.purchasedAmount; i++) {
            List<Integer> lottoNumbers = LottoGenerator.generateRandomLotto();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
    }

    private void getWinnerLotto() {
        List<Integer> numbers = InputView.getLottoNumbers();
        setWinnerLotto(new Lotto(numbers));

        int bonusNumber = InputView.getBonusNumber(numbers);
        setBonusNumber(bonusNumber);
    }

    private int[] compareWinnerAndPurchased(Lotto lotto) {
        int normalHitCount = 0;
        int bonusHitCount = 0;

        for (Integer number : lotto.getNumbers()) {
            if (this.winnerLotto.getNumbers().contains(number)) {
                normalHitCount += HIT_TICK;
            }
            if (this.bonusNumber == number) {
                bonusHitCount += HIT_TICK;
            }
        }

        return new int[]{normalHitCount, bonusHitCount};
    }
}
