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
    private int purchasedAmount = 0;
    private List<Lotto> lottos = new ArrayList<>();

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
}
